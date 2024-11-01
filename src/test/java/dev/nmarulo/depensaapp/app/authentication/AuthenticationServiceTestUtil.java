package dev.nmarulo.depensaapp.app.authentication;

import dev.nmarulo.depensaapp.FakeTestUtil;
import dev.nmarulo.depensaapp.app.authentication.dtos.AuthenticationReq;
import dev.nmarulo.depensaapp.app.authentication.dtos.AuthenticationRes;
import dev.nmarulo.depensaapp.app.users.User;
import lombok.Getter;

import java.util.Collections;

@Getter
public class AuthenticationServiceTestUtil {
    
    private final AuthenticationReq authenticationReq;
    
    private final AuthenticationRes authenticationRes;
    
    private final User user;
    
    private final String jwtIssuer;
    
    private final long plusSecondsJwtExpiresAt;
    
    public AuthenticationServiceTestUtil() {
        this.user = initUser();
        
        final var userRes = initUserRes(this.user);
        
        this.authenticationReq = initAuthenticationReq(this.user);
        this.authenticationRes = initAuthenticationRes(userRes);
        this.jwtIssuer = FakeTestUtil.randomWord();
        this.plusSecondsJwtExpiresAt = FakeTestUtil.randomLong();
    }
    
    private AuthenticationRes.User initUserRes(User user) {
        AuthenticationRes.User userRes = new AuthenticationRes.User();
        
        userRes.setId(user.getId());
        userRes.setUsername(user.getUsername());
        
        return userRes;
    }
    
    private User initUser() {
        User user = new User();
        
        user.setId(FakeTestUtil.randomLong());
        user.setUsername(FakeTestUtil.randomUsername());
        user.setPassword(FakeTestUtil.randomPassword());
        user.setEmail(FakeTestUtil.randomEmail());
        user.setCreatedAt(FakeTestUtil.randomPast());
        user.setUpdatedAt(FakeTestUtil.randomFuture());
        user.setShoppingLists(Collections.emptySet());
        
        return user;
    }
    
    private AuthenticationRes initAuthenticationRes(AuthenticationRes.User user) {
        AuthenticationRes authenticationRes = new AuthenticationRes();
        
        authenticationRes.setAccessToken(FakeTestUtil.randomWord());
        authenticationRes.setUser(user);
        
        return authenticationRes;
    }
    
    private AuthenticationReq initAuthenticationReq(User user) {
        AuthenticationReq authenticationReq = new AuthenticationReq();
        
        authenticationReq.setUsername(user.getUsername());
        authenticationReq.setPassword(user.getPassword());
        
        return authenticationReq;
    }
    
}
