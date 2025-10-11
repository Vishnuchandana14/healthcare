package com.vishnu.hospital.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vishnu.hospital.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtException;


@Service
public class JwtService {
	
	@Value("${spring.secret-key}")
	private String secretkey;
	
	
	 public SecretKey getSecretKey() {
	        return Keys.hmacShaKeyFor(secretkey.getBytes(StandardCharsets.UTF_8));
	 }
	 

    public String generateToken(User user) {
         return Jwts.builder()
            .subject(String.valueOf(user.getId())) // subject expects a String
            .claim("name", user.getUsername())
            .claim("roles", user.getRoles())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
            .signWith(getSecretKey())
            .compact();
    }
    
    public Long getUserIdFromToken(String token) {
    	Claims claims = Jwts.parser()
    			.verifyWith(getSecretKey())
    			.build()
    			.parseSignedClaims(token)
    			.getPayload();
    	return Long.valueOf(claims.getSubject());
    }

    public String extractUsername(String token) {
    	Claims claims = Jwts.parser()
    			.verifyWith(getSecretKey())
    			.build()
    			.parseSignedClaims(token)
    			.getPayload();
    	return claims.get("username", String.class);
    }


	 public boolean validateToken(String token) {
		 try {
			 Jwts.parser()
			 .verifyWith(getSecretKey())
			 .build()
			 .parseSignedClaims(token);
			 return true;
		 } catch(JwtException | IllegalArgumentException e) {
			 return false;
		 }
	 }
	 

}
