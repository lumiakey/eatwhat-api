package com.what2e.eatwhat.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.SecretKey;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author lumike
 * @version v1.0
 * @title JWTUtil
 * @date 19-5-10 下午3:13
 * @Description jwt工具类
 **/
public class JWTUtil {

    static SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static boolean checkToken(String token) {
        boolean flag = false;
        if(!StringUtils.isBlank(token)) {
            if (token.split("\\.").length == 3) {
                flag = true;
            }
        }
        return flag;
    }

    public static String getToken(int userId) {
        String token = Jwts.builder()
                .setSubject("userToken")
                .claim("id", userId)
                .signWith(key)
                .compact();
        return token;
    }

    public static Integer getUserIdByToken(String token) {
        if (checkToken(token)) {
            try {
                if (Jwts.parser()
                        .setSigningKey(key)
                        .parseClaimsJws(token)
                        .getBody().getSubject()
                        .equals("userToken")) {
                    Claims body = Jwts.parser().requireSubject("userToken").setSigningKey(key).parseClaimsJws(token).getBody();
                    return (Integer) body.get("id");
                } else {
                    return null;
                }
            } catch (SignatureException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        String token = getToken(1);
        System.out.println(token);
        System.out.println(getUserIdByToken(token));
        System.out.println(Jwts.parser().requireSubject("userToken").setSigningKey(key).parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyVG9rZW4iLCJpZCI6MX0.LTZz2wCdMmhukBVUbH7j7dWbjv72M-UhQy7U2U2idhU")
                .getBody().get("id"));
        System.out.println(checkToken(token));
    }

}
