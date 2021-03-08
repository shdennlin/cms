package org.shdennlin.cms.service.userJWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public final class JWTEncrypt extends JWTBase {

    /**
     *
     * generate token after encryption
     *
     * @param claimMap
     * @return token after encryption
     */
    public String getToken(Map<String, String> claimMap){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + 60L * 3600L * 1000L);
            JWTCreator.Builder jwtBuilder = JWT.create()
                    .withIssuer("auth0");

            for(String key: claimMap.keySet()){
                jwtBuilder = jwtBuilder.withClaim(key, claimMap.get(key));
            }

            token = jwtBuilder
                    .withExpiresAt(expiresAt)
                    .sign(Algorithm.HMAC256(SECRET));
            // mysecret是用来加密数字签名的密钥。
            // .sign(Algorithm.HMAC256(SECRET));

        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        } catch (IllegalArgumentException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return token;
    }

}
