package vn.edu.fpt.mola.bom.repository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import vn.edu.fpt.mola.bom.entity.Gender;
import vn.edu.fpt.mola.bom.entity.MolaRole;
import vn.edu.fpt.mola.bom.entity.MolaUser;


@Repository
public class InMemoryMolaUserRepository implements MolaUserRepository
{

    private final Map<Integer, MolaUser> database = new Hashtable<>();
    private volatile int molaUserIdSequence = 1;

    public InMemoryMolaUserRepository()
    {
        MolaUser user1 = new MolaUser();
        user1.setId(getNextMolaUserId());
        user1.setName("ThanhNP");
        user1.setEmail("thanhnp@fpt.edu.vn");
        user1.setGender(Gender.MALE);
        user1.setBirthday(LocalDate.of(1993, 01, 01).atStartOfDay().toInstant(ZoneOffset.UTC));
        user1.setTelNo("111");
        user1.setRole(new MolaRole[] {MolaRole.LEANER});
        this.database.put(user1.getId(), user1);
        MolaUser user2 = new MolaUser();
        user2.setId(getNextMolaUserId());
        user2.setName("HungVK");
        user2.setEmail("hungvk@fpt.edu.vn");
        this.database.put(user2.getId(), user2);
        MolaUser user3 = new MolaUser();
        user3.setId(getNextMolaUserId());
        user3.setName("DuyNC");
        user3.setEmail("duync@fpt.edu.vn");
        this.database.put(user3.getId(), user3);
        MolaUser user4 = new MolaUser();
        user4.setId(getNextMolaUserId());
        user4.setName("PhucTQ");
        user4.setEmail("phuctq@fpt.edu.vn");
        this.database.put(user4.getId(), user4);
    }

    @Override
    public List<MolaUser> getAll()
    {
        return new ArrayList<>(this.database.values());
    }

    @Override
    public MolaUser get(int id)
    {
        return this.database.get(id);
    }

    @Override
    public void add(MolaUser user)
    {
        user.setId(this.getNextMolaUserId());
        this.database.put(user.getId(), user);
    }

    @Override
    public void update(MolaUser user)
    {
        this.database.put(user.getId(), user);
    }

    private synchronized int getNextMolaUserId()
    {
        return this.molaUserIdSequence++;
    }
}
