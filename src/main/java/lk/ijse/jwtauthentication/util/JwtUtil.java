package lk.ijse.jwtauthentication.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lk.ijse.jwtauthentication.dto.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
public class JwtUtil implements Serializable {

    private static final long serialVersionUID = 234234523523L;
    public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60 * 12;

    @Value("${jwt.secret}")
    private String secretKey;

    public Claims getUserRoleCodeFromToken(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDTO userDTO) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDTO.getRole());
        return doGenerateToken(claims, userDTO.getEmail());
    }

    public String doGenerateToken(Map<String, Object> claims , String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secretKey).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String getUserNameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
}
