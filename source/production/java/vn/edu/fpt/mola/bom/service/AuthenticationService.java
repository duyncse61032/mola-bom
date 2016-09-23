package vn.edu.fpt.mola.bom.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import vn.edu.fpt.mola.bom.entity.UserPrincipal;
import vn.edu.fpt.mola.bom.validator.NotBlank;

public interface AuthenticationService
{
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
}
