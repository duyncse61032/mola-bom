package vn.edu.fpt.mola.bom.repository;

import org.springframework.data.repository.CrudRepository;

import vn.edu.fpt.mola.bom.entity.UserPrincipal;


public interface UserRepository extends CrudRepository<UserPrincipal, Long>
{
    UserPrincipal getByUsername(String username);
}
