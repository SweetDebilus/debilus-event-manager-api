package be.technifutur.debiluseventmanager.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class JWTProvider {

    private final UserDetailsService userDetailsService;

    public JWTProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String createToken(Authentication auth) {
        return JWT.create()
                .withSubject(auth.getName())
                .withExpiresAt(Instant.now().plusMillis(86400000))
                .withClaim("mood", ":)")
                .sign(Algorithm.HMAC512("sI]kM2<)P|AFg?WTPCsKHOtcMTou_Xk,5<rm*&m)BCJzk'a4W,h`jDy,>XyOejq"));
    }

    public String extractToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {

        try {
            DecodedJWT jwt = JWT.require(Algorithm.HMAC512("sI]kM2<)P|AFg?WTPCsKHOtcMTou_Xk,5<rm*&m)BCJzk'a4W,h`jDy,>XyOejq"))
                    .acceptExpiresAt(86400000)
                    .withClaim("mood", ":)")
                    .build()
                    .verify(token);

            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public Authentication createAuth(String token){

        DecodedJWT jwt = JWT.decode(token);
        String username = jwt.getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());

    }

}
