package com.example.authjwt2.controller;

import com.example.authjwt2.authentication.JwtTokenUtil;
import com.example.authjwt2.filter.JwtRequest;
import com.example.authjwt2.filter.JwtResponse;
import com.example.authjwt2.filter.JwtToken;
import com.example.authjwt2.model.UserDTO;
import com.example.authjwt2.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        //이 친구 인증원리 공부하기
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        // userDetailsService.loadUserByUsername 구현 수정하기, 수정 전 : db에서 가져오는 것이 아니라 javainuse/password 객체만 비교 가능
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        //발급한 토큰 저장하는 db 만들어주기
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            // 입력받은 정보랑 DB랑 어떻게 비교하는지 공부하기
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @RequestMapping(value = "/expiration", method = RequestMethod.POST)
    public boolean isExpired(@RequestBody JwtToken jwtToken) throws Exception {

        return jwtTokenUtil.isTokenExpired(jwtToken.getToken());
    }

    //json token 발급방법 알아보기
}