package vn.edu.fpt.mola.bom.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import vn.edu.fpt.mola.bom.entity.MolaUser;


public interface MolaUserService
{
    @NotNull
    List<MolaUser> getAllMolaUsers();

    MolaUser getMolaUser(int id);

    MolaUser saveMolaUser(@NotNull @Valid MolaUser user);

    void deleteMolaUser(int id);
}
