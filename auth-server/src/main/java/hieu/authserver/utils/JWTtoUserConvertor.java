package hieu.authserver.utils;
import java.util.Collections;

import hieu.authserver.entity.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JWTtoUserConvertor implements Converter<Jwt, UsernamePasswordAuthenticationToken>{


    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt source) {
        Account user = new Account();
        user.setId(Long.valueOf(source.getSubject()));
        return new UsernamePasswordAuthenticationToken(user, source, Collections.EMPTY_LIST);
    }
}
