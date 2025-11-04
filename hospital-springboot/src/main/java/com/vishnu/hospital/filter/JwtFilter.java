package com.vishnu.hospital.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.vishnu.hospital.entity.User;
import com.vishnu.hospital.service.JwtService;
import com.vishnu.hospital.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HandlerExceptionResolver handlerExceptionResolver;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	try {
		String headerToken = request.getHeader("Authorization");
		
		if(headerToken == null || !headerToken.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token = headerToken.substring(7);
		Long userId = jwtService.getUserIdFromToken(token);
		
		if(userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			User user = userService.getUserById(userId);
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		filterChain.doFilter(request, response);
		
	} catch(Exception ex) {
		handlerExceptionResolver.resolveException(request, response, filterChain, ex);
	}
		
	}

}
