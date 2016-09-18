package vn.edu.fpt.mola.bom.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class MolaUser
{
    private int id;
    private String name;
    private Gender gender;
    private Instant birthday;
    private String email;
    private String telNo;
    private Address address;
    private Instant createDate;
    private MolaRole[] role;
    private List<Course> courseList = new ArrayList<>();
    private List<MolaUser> following = new ArrayList<>();
    private List<MolaUser> follower = new ArrayList<>();

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public Instant getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Instant birthday)
    {
        this.birthday = birthday;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelNo()
    {
        return telNo;
    }

    public void setTelNo(String telNo)
    {
        this.telNo = telNo;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Instant getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Instant createDate)
    {
        this.createDate = createDate;
    }

    public MolaRole[] getRole()
    {
        return role;
    }

    public void setRole(MolaRole[] role)
    {
        this.role = role;
    }

    public List<Course> getCourseList()
    {
        return courseList;
    }

    public void setCourseList(List<Course> courseList)
    {
        this.courseList = courseList;
    }

    public List<MolaUser> getFollowing()
    {
        return following;
    }

    public void setFollowing(List<MolaUser> following)
    {
        this.following = following;
    }

    public List<MolaUser> getFollower()
    {
        return follower;
    }

    public void setFollower(List<MolaUser> follower)
    {
        this.follower = follower;
    }
}
