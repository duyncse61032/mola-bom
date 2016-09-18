package vn.edu.fpt.mola.bom.service;

import java.time.Instant;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import vn.edu.fpt.mola.bom.entity.MolaUser;
import vn.edu.fpt.mola.bom.repository.MolaUserRepository;


@Service
public class DefaultMolaUserService implements MolaUserService
{

    @Inject
    MolaUserRepository molaUserRepository;

    @Override
    public List<MolaUser> getAllMolaUsers()
    {
        List<MolaUser> list = this.molaUserRepository.getAll();
        list.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
        return list;
    }

    @Override
    public MolaUser getMolaUser(int id)
    {
        return this.molaUserRepository.get(id);
    }

    @Override
    public MolaUser saveMolaUser(MolaUser user)
    {
        if (user.getId() < 1) {
            user.setCreateDate(Instant.now());
            this.molaUserRepository.add(user);
        } else {
            this.molaUserRepository.update(user);
        }
        
        return user;
    }

    @Override
    public void deleteMolaUser(int id)
    {
    }

}
