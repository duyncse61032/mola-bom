package vn.edu.fpt.mola.bom.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import vn.edu.fpt.mola.bom.entity.UserPrincipal;


public interface UserService
{
    @NotNull
    List<UserPrincipal> getAllUsers();

    UserPrincipal getUser(long id);

    UserPrincipal saveUser(@NotNull @Valid UserPrincipal user);

    void deleteUser(long id);
}
