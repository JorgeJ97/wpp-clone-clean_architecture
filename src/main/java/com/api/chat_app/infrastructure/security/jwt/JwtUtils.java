package com.api.chat_app.infrastructure.security.jwt;

import com.api.chat_app.domain.entity.User;
import com.api.chat_app.domain.interfaces.service.TokenCreator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils implements TokenCreator {

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expiration.time}")
    private String expirationTime;

    @Value ("${jwt.refresh.expiration.time}")
    private String refreshExpirationTime;



    public String generateToken(User user){
        return buildToken(user, expirationTime);

    }

    public String generateRefreshToken(User user){
        return buildToken(user, refreshExpirationTime);

    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String email = extractEmail(token);
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractEmail(String token){
        return extractClaim(token, Claims::getSubject);

    }


    private String buildToken(User user, String expirationTime){
        return Jwts.builder()
                .id(user.getId())
                .claims(Map.of("username",user.getUsername()))
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + Long.parseLong(expirationTime)))
                .signWith(getSignKey())
                .compact();
    }

    private SecretKey getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    private Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private  <T> T extractClaim(String token, Function<Claims, T> claimsTFunction){
        final var claims =  extractAllClaims(token);
        return claimsTFunction.apply(claims);

    }

    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

}
