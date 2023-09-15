package com.example.demo.jwt;


import com.example.demo.security.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;


@Slf4j
@Component
public class JwtTokenProvider {
    @Value("${demo.security.secret}")
    private String SECRET_KEY;

    @Value("${demo.security.expire}")
    private int EXPIRE_TIME;


    public String generateToken(CustomUserDetails customUserDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRE_TIME);

        return Jwts.builder()
                .setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            log.error(String.valueOf(e));
            return false;
        }
    }

}
