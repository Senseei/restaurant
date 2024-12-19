package com.senseei.restaurant.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtService {

    @Value("${api.jwt-secret}")
    private String jwtSecret;

    private final Integer jwtExpirationMs = 1000 * 3600 * 24;

    public String generateToken(UserDetails userDetails) {
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);

            return true;
        } catch (Exception ex) {
            System.out.println("Invalid JWT token: " + ex.getMessage());
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        // Parse the token to extract claims
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey()) // Provide the signing key
                .build()
                .parseClaimsJws(token) // Parses and validates the token
                .getBody(); // Extract the payload (claims)

        // Return the "sub" (subject) field which typically contains the username
        return claims.getSubject();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }
}
