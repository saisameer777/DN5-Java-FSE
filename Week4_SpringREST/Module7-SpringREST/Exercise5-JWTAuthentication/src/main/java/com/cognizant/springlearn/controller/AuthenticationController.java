package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("Authenticated user: {}", user);

        String token = generateToken(user);
        LOGGER.debug("Generated token: {}", token);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("End");
        return map;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);
        return credentials.split(":")[0];
    }

    private String generateToken(String username) {
        long now = System.currentTimeMillis();
        long expiry = now + 20 * 60 * 1000;

        String header  = Base64.getEncoder().encodeToString("{\"alg\":\"HS256\"}".getBytes());
        String payload = Base64.getEncoder().encodeToString(
                ("{\"sub\":\"" + username + "\",\"iat\":" + now + ",\"exp\":" + expiry + "}").getBytes());
        String signature = Base64.getEncoder().encodeToString(
                (header + "." + payload + ".secretkey").getBytes());

        return header + "." + payload + "." + signature;
    }
}
