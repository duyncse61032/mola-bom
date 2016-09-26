package vn.edu.fpt.mola.bom.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.edu.fpt.mola.bom.entity.UserPrincipal;
import vn.edu.fpt.mola.bom.repository.UserRepository;


@Service
public class DefaultUserService implements UserService
{
    @Inject
    UserRepository userRepository;

    @Override
    @Transactional
    public List<UserPrincipal> getAllUsers()
    {
        Iterable<UserPrincipal> iterable = this.userRepository.findAll();
        List<UserPrincipal> list = new ArrayList<UserPrincipal>();
        for (UserPrincipal userPrincipal : iterable) {
            list.add(userPrincipal);
        }
        return list;
    }

    @Override
    public UserPrincipal getUser(long id)
    {
        return this.userRepository.findOne(id);
    }

    @Override
    public UserPrincipal saveUser(UserPrincipal user)
    {
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(long id)
    {
    }
}
