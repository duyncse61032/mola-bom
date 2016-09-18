package vn.edu.fpt.mola.bom.repository;

import java.util.List;

import vn.edu.fpt.mola.bom.entity.MolaUser;


public interface MolaUserRepository
{

    List<MolaUser> getAll();

    MolaUser get(int id);

    void add(MolaUser user);

    void update(MolaUser user);

}
