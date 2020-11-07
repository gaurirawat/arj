package com.example.arj;

import com.example.arj.Models.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;

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
import java.util.Date;

import static com.example.arj.Utils.Constants.*;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

     @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            Account applicationUser = new ObjectMapper().readValue(req.getInputStream(), Account.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(applicationUser.getUsername(),
                            applicationUser.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        Date exp = new Date(System.currentTimeMillis() + EXPIRY);
//        Key key = Keys.hmacShaKeyFor(KEY.getBytes());
        byte[] apiKeySecretBytes =  DatatypeConverter.parseBase64Binary(KEY);
        Key key = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
        Claims claims = Jwts.claims().setSubject(((User) auth.getPrincipal()).getUsername());
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,key).setExpiration(exp).compact();
//        String token = ((User)auth.getPrincipal()).getUsername()+":token";

        //to add token to the header
//        res.addHeader("token", token);
//        Cookie cookie = new Cookie(HEADER_NAME,token);
////        cookie.setDomain("localhost.com");
//        cookie.setSecure(false);
//        cookie.setPath("/");
//        cookie.setMaxAge(30*60);
//        res.addCookie(cookie);
//        cookie.se
//        cookie.setHttpOnly(true);   //only accessible by server and not javascript to avoid cross site scripting(XSS) attack
        res.setHeader("Set-Cookie",HEADER_NAME+"="+token+";SameSite=None;Secure;Max-Age=1800;");
    }

}
