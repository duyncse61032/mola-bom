package vn.edu.fpt.mola.bom.rest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import vn.edu.fpt.mola.bom.config.annotation.RestEndpoint;
import vn.edu.fpt.mola.bom.entity.UserPrincipal;
import vn.edu.fpt.mola.bom.entity.view.UserForm;
import vn.edu.fpt.mola.bom.service.AuthenticationService;
import vn.edu.fpt.mola.bom.validator.NotBlank;


@RestEndpoint
public class AuthenticationEndpoint
{
    private static final Logger log = LogManager.getLogger();

    @Inject
    AuthenticationService authenticationService;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid UserForm form)
    {
        UserPrincipal newUser = form.toEntity();
        this.authenticationService.saveUser(newUser,
                form.getPassword());
    }

    @RequestMapping("logout")
    @ResponseBody
    public ResponseEntity<Void> logout(HttpServletRequest request,
            HttpSession session)
    {
        if (log.isDebugEnabled() && request.getUserPrincipal() != null)
            log.debug("User {} logged out.",
                    request.getUserPrincipal().getName());
        session.invalidate();

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserPrincipal> login(HttpSession session)
    {
        UserPrincipal user = (UserPrincipal) AuthenticationService.getPrincipal(session);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(null,
                HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserPrincipal> login(HttpSession session,
            HttpServletRequest request,
            @RequestBody @Valid LoginForm form,
            Errors errors)
    {
        UserPrincipal user = (UserPrincipal) AuthenticationService.getPrincipal(session);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        if (errors.hasErrors()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        user = this.authenticationService.authenticate(
                form.getUsername(), form.getPassword());

        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        AuthenticationService.setPrincipal(session, user);
        request.changeSessionId();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public static class LoginForm
    {
        @NotBlank(message = "{validate.authenticate.username}")
        private String username;
        @NotBlank(message = "{validate.authenticate.password}")
        private String password;

        public String getUsername()
        {
            return username;
        }

        public void setUsername(String username)
        {
            this.username = username;
        }

        public String getPassword()
        {
            return password;
        }

        public void setPassword(String password)
        {
            this.password = password;
        }
    }
}
