package com.JavaBootcamp03.mobilestore.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@NoArgsConstructor
@Component
public class JwtHelper {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpirationDate;

    @Autowired
    public JwtHelper(@Value("${jwt.secret}")String jwtSecret, @Value("${jwt.expiration}") long jwtExpirationDate){
        this.jwtSecret = jwtSecret;
        this.jwtExpirationDate = jwtExpirationDate;
    }


    // generate JWT token
    public String generateToken(String data){
        System.out.println("Kiem tra jwtSecret: " + jwtSecret);
        System.out.println("Kiem tra jwtExpirationDate: " + jwtExpirationDate);

        Date date = new Date();
        long futureMilis = date.getTime() + jwtExpirationDate;
        Date futureDate = new Date(futureMilis);

        String token = Jwts.builder()
                .subject(data)
                .issuedAt(date)
                .expiration(futureDate)
                .signWith(key())
                .compact();

        System.out.println("kiem tra token: " + token);
        return token;
    }

    //Chuyển key đã lưu trữ từ dạng base64 về SecrectKey
    private SecretKey key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    // validate JWT token
    public String decodeToken(String token){
        String data = null;

        try{
            data = Jwts.parser()
                    .verifyWith(key())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        }catch (Exception e){
            System.out.println("Lỗi parser token " + e.getMessage());
        }

        return data;
    }
}