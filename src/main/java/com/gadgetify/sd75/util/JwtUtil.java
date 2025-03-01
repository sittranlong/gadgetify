package com.gadgetify.sd75.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "G3oO2PjK_Y7h1rX8wMZqF5tLdV9N6bQ0A4CpJvKUgYsTIHfXWEmc";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 24 giờ

    public String taoToken(String email, String vaiTro) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("vaiTro", vaiTro);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public Claims layClaimsTuToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean kiemTraTokenHopLe(String token) {
        try {
            Claims claims = layClaimsTuToken(token);
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String layMaEmailTuClaims(String token) {
        Claims claims = layClaimsTuToken(token);
        return claims.get("email").toString(); // Lấy từ claims
    }
}
