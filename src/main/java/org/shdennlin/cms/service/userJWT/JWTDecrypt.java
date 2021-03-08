package org.shdennlin.cms.service.userJWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;

public class JWTDecrypt extends JWTBase{

    /**
     * 先验证token是否被伪造，然后解码token。
     *
     * @param token
     * @return 解密后的DecodedJWT对象，可以读取token中的数据。
     */
    public DecodedJWT deToken(final String token) {
        DecodedJWT jwt = null;
        try {
            // 使用了HMAC256加密算法。
            // mysecret是用来加密数字签名的密钥。
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET))
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            jwt = verifier.verify(token);
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            //exception.printStackTrace();
            return null;
            //throw exception;
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            return null;
            //throw e;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            //throw e;
            return null;
        }

        return jwt;
//        return JWT.decode(token);

    }
}
