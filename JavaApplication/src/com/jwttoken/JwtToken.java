package com.jwttoken;

import java.security.Key;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtToken {
	public static void main(String args[])
	{
		String jwtToken = generateJwtToken();
		validateJwtToken(jwtToken);
	}
	public static Key getSignatureKey()
	{
		String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
		Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());
		return hmacKey;
	}
	public static String generateJwtToken()
	{
		Instant now = Instant.now();
		String jwtToken = Jwts.builder()
							.claim("email","narendran3678@gmail.com")
							.claim("password", "123")
							.setSubject("Authenication")
							.setIssuedAt(Date.from(now))
							.setExpiration(Date.from(now.plusSeconds(60)))
							.signWith(getSignatureKey())
							.compact();
		return jwtToken;
	}
	public static void validateJwtToken(String token)
	{
		try
		{
			Jws<Claims> jwtClaims = Jwts.parserBuilder().setSigningKey(getSignatureKey()).build().parseClaimsJws(token);
			Claims claims = jwtClaims.getBody();
			System.out.println(claims);
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
	}
}
