package com.qualentraglobal.astraq.security.jwt;


import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    //public static final String SECRET = "5367566859703373367639792F423F452848284D6251655468576D5A71347437";
    private static final String SECRET_KEY = "5367566859703373367639792F423F452848284D6251655468576D5A71347437"; // must be at least 256 bits
    private static final long EXPIRATION_TIME = 1000 * 60 * 30; // 30 minutes

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());


    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("self")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token, String username) {
        String tokenUsername = extractUsername(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }
}