package com.i61.sqlexe.service;

import java.sql.*;


/**
 * @program: sql-executor
 * @description: 执行器的记录服务
 * @author: yanyao
 * @create: 2019-07-05 14:30
 **/
public class ExecutorRecordService {

    class BaseDb {
        String userName = "root";
        String password = "dbtest";
        String Url = "jdbc:mysql://10.60.7.251:3306/i61?autoReconnect=true&useAffectedRows=true";
        String selectBySystemAndSqlName = "SELECT id FROM sql_executor_record WHERE System=? AND SqlName=?";
        String insert = "INSERT INTO `sql_executor_record`(System,Gitlab,Executor,SqlName) VALUES (?, ?,?, ?)";

        private Connection getConnect() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection(Url, userName, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        Integer selectBySystemAndSqlName(String system, String sqlName) throws SQLException {
            Connection connect = getConnect();
            PreparedStatement ps = connect.prepareStatement(selectBySystemAndSqlName);
            ps.setString(1, system);
            ps.setString(2, sqlName);
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            Integer id = null;
            while (resultSet.next()) {
                id = resultSet.getInt("Id");
            }
            return id;
        }
        void insertRecord(String system, String gitlab, String executor, String sqlName) throws SQLException {
            Connection connect = getConnect();
            PreparedStatement ps = connect.prepareStatement(insert);
            ps.setString(1, system);
            ps.setString(2, gitlab);
            ps.setString(3, executor);
            ps.setString(4, sqlName);
            ps.execute();
        }
    }

    public boolean isExist(String system, String sqlName) throws Exception {
        boolean result = true;
        if ("".equals(system) || system.equals(null)) {
            throw new Exception("runConfig System 参数配置错误！");
        }
        Integer integer = new BaseDb().selectBySystemAndSqlName(system, sqlName);
        if (integer == null) {
            result = false;
        }
        return result;
    }

    public void addExecutorRecord(String system, String gitlab, String executor, String sqlName) throws Exception {
        if ("".equals(system) || system == null || "".equals(gitlab) || gitlab == null ||  "".equals(sqlName) || sqlName == null) {
            throw new Exception("runConfig System 参数配置错误！");
        }
        new BaseDb().insertRecord(system, gitlab, executor, sqlName);
    }
}
