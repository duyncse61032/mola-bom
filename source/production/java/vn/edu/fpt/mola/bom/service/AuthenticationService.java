package vn.edu.fpt.mola.bom.service;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import vn.edu.fpt.mola.bom.entity.UserPrincipal;
import vn.edu.fpt.mola.bom.validator.NotBlank;

public interface AuthenticationService
{
    public static final String SESSION_ATTRIBUTE_KEY = "com.wrox.user.principal";
    
    UserPrincipal authenticate(
            @NotBlank(message = "{validate.authenticate.username}")
                String username,
            @NotBlank(message = "{validate.authenticate.password}")
                String password
    );

    void saveUser(
            @NotNull(message = "{validate.authenticate.saveUser}") @Valid
                UserPrincipal principal,
            String newPassword);
    

    public static Principal getPrincipal(HttpSession session) {
        return session == null ? null :
                (Principal)session.getAttribute(SESSION_ATTRIBUTE_KEY);
    }
    
    public static void setPrincipal(HttpSession session, Principal principal)     {
        session.setAttribute(SESSION_ATTRIBUTE_KEY, principal);
    }
}
