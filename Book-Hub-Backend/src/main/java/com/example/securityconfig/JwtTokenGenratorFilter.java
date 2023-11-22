package com.example.securityconfig;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenGenratorFilter extends OncePerRequestFilter {
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		if (authentication != null ) {
			
			SecretKey key = Keys.hmacShaKeyFor(JwtConstanat.SECRET_KEY.getBytes());
			String jwt = Jwts.builder()
					.setIssuer(authentication.getName())
					.setSubject("JWT Token")
					.setIssuedAt(new Date()).claim("email", authentication.getName())
					.claim("authorities", populateAuthorities(authentication.getAuthorities()))
					.setExpiration(new Date(new Date().getTime() + 30000000)) // millisecond expiration time of around 8 hours
					.signWith(key).compact();
			
			response.setHeader(JwtConstanat.JWT_HEADER, jwt);
		}

		filterChain.doFilter(request, response);

	}

	private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {

		Set<String> authoritiesSet = new HashSet<>();

		for (GrantedAuthority authority : collection) {
			authoritiesSet.add(authority.getAuthority());
		}
		return String.join(",", authoritiesSet);

	}
	
	

	// this make sure that this filter will execute only for first time when client call the api /signIn at first time
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

		return !request.getServletPath().equals("/auth/signin");
	}
	

}
