package com.i61.sqlexe;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by jeffwei on 2015/10/7.
 */
public class SqlParser {
    private static final List<String> SQL_TRIGGER_SIGN = new ArrayList<>();
    static {
        SQL_TRIGGER_SIGN.add("&&");
        SQL_TRIGGER_SIGN.add("//");
    }
    private static final List<String> SQL_KEY_WORD_FOR_CHECK_DELIMITER = new ArrayList<>();
    static {
        SQL_KEY_WORD_FOR_CHECK_DELIMITER.add("PROCEDURE");
        SQL_KEY_WORD_FOR_CHECK_DELIMITER.add("TRIGGER");
    }

    private static final String SQL_SEPARATOR = "\n|\r\n|\r";
    private static final String SQL_TRIGGER_DELIMITER = "DELIMITER";

    private static final char SQL_NULL = ' ';
    private static final char SQL_ESC = '\\';
    private static char SQL_DELIMITER = ';';
    private static final char SQL_CONTENT = '\'';
    private static final char SQL_CONTENT_UNDEFINED = '"';
    private static final char SQL_CONTENT_DB = '`';
    private static final char SQL_COMMENT_0 = '-';
    private static final char SQL_COMMENT_1 = '-';
    private static final char SQL_COMMENT_MULTI_LINE_START_0 = '/';
    private static final char SQL_COMMENT_MULTI_LINE_START_1 = '*';
    private static final char SQL_COMMENT_MULTI_LINE_START_2 = '!';
    private static final char SQL_COMMENT_MULTI_LINE_END_0 = '*';
    private static final char SQL_COMMENT_MULTI_LINE_END_1 = '/';


    private static SqlParser instance = null;

    private int blankCount;
    private boolean isESC;
    private boolean isDelimiter;
    private boolean isContent;
    private boolean isContentUndefined;
    private boolean isContentDB;
    private boolean isComment;
    private boolean isCommentMultiLine;

    private StringBuilder sqlBuilder;
    private ArrayList<String> sqls;


    public static SqlParser getInstance() {
        synchronized (SqlParser.class) {
            if (null == instance) {
                instance = new SqlParser();
            }
            return instance;
        }
    }

    private SqlParser() {
    }

    public synchronized Collection<String> parseSqlText(String sqlText) throws ParseException {
        Collection<String> rs = null;

        if (null != sqlText) {
            rs = new ArrayList<>();
            this.init();
            String[] sqlSources = sqlText.split(SQL_SEPARATOR);

            for (String sqlSource : sqlSources) {
                this.parseSqlSource(sqlSource);
            }

            if (0 < this.sqlBuilder.length()) {
                this.appendSql(this.sqlBuilder.toString());
            }

            parseTrigger();
            rs.addAll(this.sqls);
            this.dispose();
        }

        return rs;
    }

    private void parseTrigger() throws ParseException {
        ArrayList<String> sqlsNew = new ArrayList<>();
        StringBuilder sqlNewSB = new StringBuilder();
        boolean haveFoundTriggerDelimiter = false;
        int indexSql = 0;
        String regexp = "DELIMITER .*;";
        Pattern pattern = Pattern.compile(regexp);
        for (String sql : this.sqls) {
            String sign = isSqlContainOneOfList(sql, SQL_TRIGGER_SIGN);
            if(!haveFoundTriggerDelimiter && sql.toUpperCase().contains(SQL_TRIGGER_DELIMITER) && sign != null){
                haveFoundTriggerDelimiter = true;
                String[] sqls = sql.split(sign);
                String firstSqlOfTrigger = sqls[1].trim();
                if(isSqlContainOneOfList(sql, SQL_KEY_WORD_FOR_CHECK_DELIMITER) == null){//如果第一句sql不包含SQL_KEY_WORD_FOR_CHECK_DELIMITER中的任一关键的话，报错！
                    throw new ParseException("非法触发器/存储过程sql！", indexSql);
                }
                sqlNewSB.append(firstSqlOfTrigger);
            }else if(haveFoundTriggerDelimiter && sign != null){
                String[] sqls = sql.split(sign);
                sqlNewSB.append(sqls[0].trim());
                sqlsNew.add(sqlNewSB.toString());
                if(sqls.length < 2 || !pattern.matcher(sqls[1].toUpperCase()).find()){
                    throw new ParseException("非法触发器/存储过程sql！", indexSql);
                }
                sqlNewSB = new StringBuilder();
                haveFoundTriggerDelimiter = false;
            }else if(haveFoundTriggerDelimiter && sign == null){
                sqlNewSB.append(sql);
            }else{
                sqlsNew.add(sql);
            }
            ++ indexSql;
        }
        this.sqls.clear();
        this.sqls = sqlsNew;
    }

    private String isSqlContainOneOfList(String sql, List<String> subString){
        if(sql == null || sql == "" || subString == null || subString.size() <= 0){
            return null;
        }
        for (String sub : subString) {
            if(sql.contains(sub)){
                return sub;
            }
        }
        return null;
    }

    private void parseSqlSource(String sqlSource) {
        if (null != sqlSource) {
            sqlSource = sqlSource.trim();
            if(sqlSource.toUpperCase().startsWith(SQL_TRIGGER_DELIMITER)){
                String[] delimiterChars = sqlSource.split("\\s+");
                if(delimiterChars.length<2 || delimiterChars[1].length()>1){
                    throw new RuntimeException("delimiter语法有误,分隔符只能是单个字符");
                }
                SQL_DELIMITER=delimiterChars[1].charAt(0);
                return;
            }
            if (0 != sqlSource.length()) {
                this.blankCount = 0;
                this.isESC = false;
                char[] sqlChars = sqlSource.toCharArray();

                for (int i = 0; i < sqlChars.length; i++) {
                    char sqlChar = sqlChars[i];
                    boolean isLastDelimiter = this.isDelimiter;
                    this.isDelimiter = false;

                    if (this.isComment()) {
                        if (SQL_COMMENT_MULTI_LINE_END_0 == sqlChar) {
                            if (SQL_COMMENT_MULTI_LINE_END_1 == this.getChar(sqlChars, 1 + i)) {
                                this.isCommentMultiLine = false;
                                i++;
                            }
                        }

                        continue;
                    }

                    if (SQL_ESC == sqlChar) {
                        this.isESC = !this.isESC;
                    } else {
                        if (SQL_NULL == sqlChar) {
                            if (!this.isContent()) {
                                if (0 == this.blankCount && 0 < this.sqlBuilder.length()) {
                                    this.sqlBuilder.append(sqlChar);
                                    this.blankCount++;
                                }

                                continue;
                            }
                        } else if (SQL_DELIMITER == sqlChar) {
                            if (!this.isContent()) {
                                this.isDelimiter = true;
                                this.blankCount = 0;
//                                this.sqlBuilder.append(sqlChar);
                                this.appendSql(this.sqlBuilder.toString());
                                this.sqlBuilder.delete(0, this.sqlBuilder.length());

                                continue;
                            }
                        } else if (SQL_CONTENT == sqlChar && !this.isESC()) {
                            if (!this.isContentUndefined && !this.isContentDB) {
                                this.isContent = !this.isContent;
                            }
                        } else if (SQL_CONTENT_UNDEFINED == sqlChar && !this.isESC()) {
                            if (!this.isContent && !this.isContentDB) {
                                this.isContentUndefined = !this.isContentUndefined;
                            }
                        } else if (SQL_CONTENT_DB == sqlChar && !this.isESC()) {
                            if (!this.isContent && !this.isContentUndefined) {
                                this.isContentDB = !this.isContentDB;
                            }
                        } else if (SQL_COMMENT_0 == sqlChar) {
                            if (!this.isContent()) {
                                if (SQL_COMMENT_1 == this.getChar(sqlChars, 1 + i)) {
                                    this.isComment = false;
                                    this.isDelimiter = isLastDelimiter;
                                    this.blankCount = 0;

                                    break;
                                }
                            }
                        } else if (SQL_COMMENT_MULTI_LINE_START_0 == sqlChar) {
                            if (!this.isContent()) {
                                if (SQL_COMMENT_MULTI_LINE_START_1 == this.getChar(sqlChars, 1 + i) && SQL_COMMENT_MULTI_LINE_START_2 != this.getChar(sqlChars, 2 + i)) {
                                    this.isCommentMultiLine = true;
                                    this.isDelimiter = isLastDelimiter;
                                    this.blankCount = 0;
                                    i++;

                                    continue;
                                }
                            }
                        }

                        this.isESC = false;
                    }

                    this.blankCount = 0;
                    this.sqlBuilder.append(sqlChar);
                }

                if (!this.isDelimiter && 0 == blankCount) {
                    this.sqlBuilder.append(SQL_NULL);
                }
            }
        }
    }

    private char getChar(char[] charArray, int index) {
        char rs = SQL_NULL;

        if (null != charArray) {
            if (0 <= index && charArray.length > index) {
                rs = charArray[index];
            }
        }

        return rs;
    }

    private boolean isESC() {
        return this.isESC;
    }

    private boolean isContent() {
        return this.isContent || this.isContentUndefined || this.isContentDB;
    }

    private boolean isComment() {
        return this.isComment || this.isCommentMultiLine;
    }

    private void appendSql(String sql) {
        if (null != sql) {
            sql = sql.trim();

            if (0 != sql.length()) {
                this.sqls.add(sql);
            }
        }
    }

    private void init() {
        this.blankCount = 0;
        this.isESC = false;
        this.isDelimiter = false;
        this.isContent = false;
        this.isContentUndefined = false;
        this.isContentDB = false;
        this.isComment = false;
        this.isCommentMultiLine = false;

        if (null == this.sqlBuilder) {
            this.sqlBuilder = new StringBuilder();
        } else {
            this.sqlBuilder.delete(0, this.sqlBuilder.length());
        }

        if (null == this.sqls) {
            this.sqls = new ArrayList<>();
        } else {
            this.sqls.clear();
        }
    }

    private void dispose() {
        this.blankCount = 0;
        this.isESC = false;
        this.isDelimiter = false;
        this.isContent = false;
        this.isContentUndefined = false;
        this.isContentDB = false;
        this.isComment = false;
        this.isCommentMultiLine = false;
        this.sqlBuilder.delete(0, this.sqlBuilder.length());
        this.sqls.clear();
    }

}
