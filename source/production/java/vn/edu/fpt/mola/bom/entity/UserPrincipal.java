package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vn.edu.fpt.mola.bom.entity.converter.InstantConverter;
import vn.edu.fpt.mola.bom.entity.enumerate.Gender;


/**
 * The persistent class for the userprincipal database table.
 * 
 */
@Entity
@NamedQuery(name = "UserPrincipal.findAll",
        query = "SELECT u FROM UserPrincipal u")
public class UserPrincipal implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long id;
    private String username;
    private byte[] hashedPassword;
    private Instant birthday;
    private String displayName;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String nameSuffix;
    private String title;
    private Address address;
    private List<Course> courseList;
    private List<Enroll> enrollList;
    private List<Meeting> learningMeetingList;
    private List<Meeting> teachingMeetingList;
    private List<Rank> rankList;
    private List<TimeFrame> timeFrameList;
    private List<Usedlanguage> usedLanguageList;
    private List<Role> roleList;
    private List<UserPrincipal> followerList;
    private List<UserPrincipal> followeeList;

    public UserPrincipal()
    {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Convert(converter = InstantConverter.class)
    public Instant getBirthday()
    {
        return this.birthday;
    }

    public void setBirthday(Instant birthday)
    {
        this.birthday = birthday;
    }

    public String getDisplayName()
    {
        return this.displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Enumerated(EnumType.STRING)
    public Gender getGender()
    {
        return this.gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public byte[] getHashedPassword()
    {
        return this.hashedPassword;
    }

    public void setHashedPassword(byte[] hashedPassword)
    {
        this.hashedPassword = hashedPassword;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getNameSuffix()
    {
        return this.nameSuffix;
    }

    public void setNameSuffix(String nameSuffix)
    {
        this.nameSuffix = nameSuffix;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    // bi-directional one-to-one association to Address
    @OneToOne(mappedBy = "userPrincipal", fetch = FetchType.LAZY)
    public Address getAddress()
    {
        return this.address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Course
    @OneToMany(mappedBy = "author")
    public List<Course> getCourseList()
    {
        return this.courseList;
    }

    public void setCourseList(List<Course> courseList)
    {
        this.courseList = courseList;
    }

    public Course addCourse(Course course)
    {
        getCourseList().add(course);
        course.setAuthor(this);

        return course;
    }

    public Course removeCourse(Course course)
    {
        getCourseList().remove(course);
        course.setAuthor(null);

        return course;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Enroll
    @OneToMany(mappedBy = "userPrincipal")
    public List<Enroll> getEnrollList()
    {
        return this.enrollList;
    }

    public void setEnrollList(List<Enroll> enrollList)
    {
        this.enrollList = enrollList;
    }

    public Enroll addEnrollList(Enroll enrollList)
    {
        getEnrollList().add(enrollList);
        enrollList.setUserPrincipal(this);

        return enrollList;
    }

    public Enroll removeEnrollList(Enroll enrollList)
    {
        getEnrollList().remove(enrollList);
        enrollList.setUserPrincipal(null);

        return enrollList;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Meeting
    @OneToMany(mappedBy = "learner")
    public List<Meeting> getLearningMeetingList()
    {
        return this.learningMeetingList;
    }

    public void setLearningMeetingList(List<Meeting> learningMeetingList)
    {
        this.learningMeetingList = learningMeetingList;
    }

    public Meeting addLearningMeetingList(Meeting learningMeetingList)
    {
        getLearningMeetingList().add(learningMeetingList);
        learningMeetingList.setLearner(this);

        return learningMeetingList;
    }

    public Meeting removeLearningMeetingList(Meeting learningMeetingList)
    {
        getLearningMeetingList().remove(learningMeetingList);
        learningMeetingList.setLearner(null);

        return learningMeetingList;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Meeting
    @OneToMany(mappedBy = "teacher")
    public List<Meeting> getTeachingMeetingList()
    {
        return this.teachingMeetingList;
    }

    public void setTeachingMeetingList(List<Meeting> teachingMeetingList)
    {
        this.teachingMeetingList = teachingMeetingList;
    }

    public Meeting addTeachingMeetingList(Meeting teachingMeetingList)
    {
        getTeachingMeetingList().add(teachingMeetingList);
        teachingMeetingList.setTeacher(this);

        return teachingMeetingList;
    }

    public Meeting removeTeachingMeetingList(Meeting teachingMeetingList)
    {
        getTeachingMeetingList().remove(teachingMeetingList);
        teachingMeetingList.setTeacher(null);

        return teachingMeetingList;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Rank
    @OneToMany(mappedBy = "user")
    public List<Rank> getRankList()
    {
        return this.rankList;
    }

    public void setRankList(List<Rank> rankList)
    {
        this.rankList = rankList;
    }

    public Rank addRankList(Rank rankList)
    {
        getRankList().add(rankList);
        rankList.setUser(this);

        return rankList;
    }

    public Rank removeRankList(Rank rankList)
    {
        getRankList().remove(rankList);
        rankList.setUser(null);

        return rankList;
    }

    @JsonIgnore
    // bi-directional many-to-one association to TimeFrame
    @OneToMany(mappedBy = "userPrincipal")
    public List<TimeFrame> getTimeFrameList()
    {
        return this.timeFrameList;
    }

    public void setTimeFrameList(List<TimeFrame> timeFrameList)
    {
        this.timeFrameList = timeFrameList;
    }

    public TimeFrame addTimeFrameList(TimeFrame timeFrameList)
    {
        getTimeFrameList().add(timeFrameList);
        timeFrameList.setUserPrincipal(this);

        return timeFrameList;
    }

    public TimeFrame removeTimeFrameList(TimeFrame timeFrameList)
    {
        getTimeFrameList().remove(timeFrameList);
        timeFrameList.setUserPrincipal(null);

        return timeFrameList;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Usedlanguage
    @OneToMany(mappedBy = "userPrincipal")
    public List<Usedlanguage> getUsedLanguageList()
    {
        return this.usedLanguageList;
    }

    public void setUsedLanguageList(List<Usedlanguage> usedLanguageList)
    {
        this.usedLanguageList = usedLanguageList;
    }

    public Usedlanguage addUsedLanguageList(Usedlanguage usedLanguageList)
    {
        getUsedLanguageList().add(usedLanguageList);
        usedLanguageList.setUserPrincipal(this);

        return usedLanguageList;
    }

    public Usedlanguage removeUsedLanguageList(Usedlanguage usedLanguageList)
    {
        getUsedLanguageList().remove(usedLanguageList);
        usedLanguageList.setUserPrincipal(null);

        return usedLanguageList;
    }

    @JsonIgnore
    // bi-directional many-to-many association to Role
    @ManyToMany
    @JoinTable(
            name = "userinrole", joinColumns = {
                    @JoinColumn(name = "UserId")
            }, inverseJoinColumns = {
                    @JoinColumn(name = "RoleId")
            })
    public List<Role> getRoleList()
    {
        return this.roleList;
    }

    public void setRoleList(List<Role> roleList)
    {
        this.roleList = roleList;
    }

    @JsonIgnore
    // bi-directional many-to-many association to UserPrincipal
    @ManyToMany
    @JoinTable(
            name = "following", joinColumns = {
                    @JoinColumn(name = "FollowerId")
            }, inverseJoinColumns = {
                    @JoinColumn(name = "FolloweeId")
            })
    public List<UserPrincipal> getFollowerList()
    {
        return this.followerList;
    }

    public void setFollowerList(List<UserPrincipal> followerList)
    {
        this.followerList = followerList;
    }

    @JsonIgnore
    // bi-directional many-to-many association to UserPrincipal
    @ManyToMany(mappedBy = "followerList")
    public List<UserPrincipal> getFolloweeList()
    {
        return this.followeeList;
    }

    public void setFolloweeList(List<UserPrincipal> followeeList)
    {
        this.followeeList = followeeList;
    }

}