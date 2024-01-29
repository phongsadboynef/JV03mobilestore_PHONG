package com.JavaBootcamp03.mobilestore.filter;

import com.JavaBootcamp03.mobilestore.jwt.JwtHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

// Execute Before Executing Spring Security Filters
@NoArgsConstructor
@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtHelper jwtHelper;

    private Gson gson = new Gson();

    public JwtFilter(JwtHelper jwtHelper) {
        this.jwtHelper = jwtHelper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Get JWT token from request header with key is Authorization
        String bearerToken = request.getHeader("Authorization");
        Optional<String> tokenOptional = Optional.ofNullable(bearerToken);

        System.out.println("Kiem tra token trong filter: " + bearerToken);

        // Validate Token
        if(tokenOptional.isPresent()) {
            String token = tokenOptional.get().substring(7);

            if(!token.isEmpty()) {
                String data = jwtHelper.decodeToken(token);

                // Create custom type to Gson support parse json with type is List
                Type listType = new TypeToken<List<SimpleGrantedAuthority>>() {}.getType();

                List<GrantedAuthority> listRoles = gson.fromJson(data,listType);
                System.out.println("kiemtra role " + data + " size List role " + listRoles.size() );

                if(data != null) {
                    // Create Context Holder to bypass Security filters
                    UsernamePasswordAuthenticationToken authenticationToken
                            = new UsernamePasswordAuthenticationToken("","",listRoles);

                    SecurityContext securityContext = SecurityContextHolder.getContext();

                    securityContext.setAuthentication(authenticationToken);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
