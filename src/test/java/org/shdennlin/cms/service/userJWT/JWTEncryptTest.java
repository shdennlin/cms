package org.shdennlin.cms.service.userJWT;


import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

class JWTEncryptTest {

    private Object Map;

    @Test
    public void test() throws Exception {
        JWTEncrypt jwtEncrypt = new JWTEncrypt();

        Map<String, String> claimMap = new HashMap<>();
        claimMap.put("username1", "pssword1");

        String token = jwtEncrypt.getToken(claimMap);
        System.out.println("token = " + token);
    }


}