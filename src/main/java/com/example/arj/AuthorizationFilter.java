package com.example.arj;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

//import static

import static com.example.arj.Utils.Constants.*;

public class AuthorizationFilter extends BasicAuthenticationFilter {
     public AuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

         //when we want to set token into headers and append in every request from front-end
//        String header = request.getHeader(HEADER_NAME);
//
//        if (header == null) {
//            chain.doFilter(request, response);
//            return;
//        }

        //when we store jwt token into coes
        Cookie[] cookies = request.getCookies();
        //if not cookie then just skip this part
        if (cookies ==null) {
//            System.out.println("No cookies!");
            chain.doFilter(request,response);   //invokes next filter from the chain
            return;
        }

        UsernamePasswordAuthenticationToken authentication = authenticate(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request) {
//        String token = request.getHeader(HEADER_NAME);
        String token=null;

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            System.out.println(cookie.toString());
            if(cookie.getName().equals(HEADER_NAME)){
                token = cookie.getValue();
                break;
            }
        }

        if (token != null) {
            byte[] apiKeySecretBytes =  DatatypeConverter.parseBase64Binary(KEY);
            Key key = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
            Claims user = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }else{
                return  null;
            }

        }
        return null;
    }
}