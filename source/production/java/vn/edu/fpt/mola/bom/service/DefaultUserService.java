package vn.edu.fpt.mola.bom.service;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.fpt.mola.bom.entity.UserPrincipal;
import vn.edu.fpt.mola.bom.repository.UserRepository;


@Service
public class DefaultUserService implements UserService
{
    private static final Logger log = LogManager.getLogger();
    private static final SecureRandom RANDOM;
    private static final int HASHING_ROUNDS = 10;

    static {
        try {
            RANDOM = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    @Inject
    UserRepository userRepository;

    @Override
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
