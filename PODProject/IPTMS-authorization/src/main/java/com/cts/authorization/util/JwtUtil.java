package com.cts.authorization.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JwtUtil {
	private String secretkey = "secret";
	
	public String extractUsername(String token) {

		return extractClaim(token, Claims::getSubject);

	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);

	}
	
	
	private Claims extractAllClaims(String token) {

		return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();

	}
	
	public String generateJwt(UserDetails userDetails) {
		Map<String,Object> claims=new HashMap<String, Object>();
		String username=userDetails.getUsername();
		
		JwtBuilder builder = Jwts.builder();
		builder.setClaims(claims);
		builder.setSubject(username);
		
		builder.setIssuedAt(new Date(System.currentTimeMillis()+5));
		
		builder.setExpiration(new Date(System.currentTimeMillis()+(1000*60*60*10*5)));
		
		builder.signWith(SignatureAlgorithm.HS256, secretkey);
		
		String token = builder.compact();
		
		return token;	
	}
	
	public Date extractExpiration(String token)
	{
		return extractClaim(token, Claims::getExpiration);
	}
	
	public boolean isTokenExpired(String token)
	{
		return extractExpiration(token).before(new Date());
	}
	
	public Boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
