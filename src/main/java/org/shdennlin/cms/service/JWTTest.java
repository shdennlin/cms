package org.shdennlin.cms.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.shdennlin.cms.service.userJWT.JWTDecrypt;
import org.shdennlin.cms.service.userJWT.JWTEncrypt;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class JWTTest {

    @Test
    public void test() throws Exception {
        // encrypt data
        JWTEncrypt jwtEncrypt = new JWTEncrypt();
        Map<String, String> claimMap = new HashMap<>();

        claimMap.put("username","shennlinXX");
        claimMap.put("password", "testpassword");

        String token = jwtEncrypt.getToken(claimMap);
        System.out.println("token: \n" + token);

        System.out.println("=================================================");

        // print token after decrypt
        // https://jwt.io/
        JWTDecrypt jwtDecrypt = new JWTDecrypt();
        DecodedJWT data = jwtDecrypt.deToken(token);

        System.out.println(data.getClaim("username").asString());
        System.out.println(data.getClaim("password").asString());
    }
}
