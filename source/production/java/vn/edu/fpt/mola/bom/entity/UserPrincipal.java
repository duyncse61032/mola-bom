package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
    private String title;
    private String firstName;
    private String lastName;
    private String nameSuffix;
    private String displayName;
    private Date birthday;
    private String gender;
    private Address address;
    private List<Course> courseList;
    private List<Enroll> enrollList;
    private List<Meeting> learningMeetingList;
    private List<Meeting> teachingMeetingList;
    private List<Rank> rankList;
    private List<TimeFrame> timeFrameList;
    private List<Language> learningLanguageList;
    private List<Language> teachingLanguageList;
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

    @Temporal(TemporalType.DATE)
    public Date getBirthday()
    {
        return this.birthday;
    }

    public void setBirthday(Date birthday)
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

    public String getGender()
    {
        return this.gender;
    }

    public void setGender(String gender)
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

    public Enroll addEnroll(Enroll enroll)
    {
        getEnrollList().add(enroll);
        enroll.setUserPrincipal(this);

        return enroll;
    }

    public Enroll removeEnroll(Enroll enroll)
    {
        getEnrollList().remove(enroll);
        enroll.setUserPrincipal(null);

        return enroll;
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

    public Meeting addLearningMeeting(Meeting learningMeeting)
    {
        getLearningMeetingList().add(learningMeeting);
        learningMeeting.setLearner(this);

        return learningMeeting;
    }

    public Meeting removeLearningMeeting(Meeting learningMeeting)
    {
        getLearningMeetingList().remove(learningMeeting);
        learningMeeting.setLearner(null);

        return learningMeeting;
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

    public Meeting addTeachingMeeting(Meeting teachingMeeting)
    {
        getTeachingMeetingList().add(teachingMeeting);
        teachingMeeting.setTeacher(this);

        return teachingMeeting;
    }

    public Meeting removeTeachingMeeting(Meeting teachingMeeting)
    {
        getTeachingMeetingList().remove(teachingMeeting);
        teachingMeeting.setTeacher(null);

        return teachingMeeting;
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

    public Rank addRank(Rank rank)
    {
        getRankList().add(rank);
        rank.setUser(this);

        return rank;
    }

    public Rank removeRank(Rank rank)
    {
        getRankList().remove(rank);
        rank.setUser(null);

        return rank;
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

    public TimeFrame addTimeFrame(TimeFrame timeFrame)
    {
        getTimeFrameList().add(timeFrame);
        timeFrame.setUserPrincipal(this);

        return timeFrame;
    }

    public TimeFrame removeTimeFrame(TimeFrame timeFrame)
    {
        getTimeFrameList().remove(timeFrame);
        timeFrame.setUserPrincipal(null);

        return timeFrame;
    }

    // bi-directional many-to-many association to Language
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "learninglanguage", joinColumns = {
                    @JoinColumn(name = "UserId")
            }, inverseJoinColumns = {
                    @JoinColumn(name = "LanguageId")
            })
    public List<Language> getLearningLanguageList()
    {
        return this.learningLanguageList;
    }

    public void setLearningLanguageList(List<Language> learningLanguageList)
    {
        this.learningLanguageList = learningLanguageList;
    }

    // bi-directional many-to-many association to Language
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "teachinglanguage", joinColumns = {
                    @JoinColumn(name = "UserId")
            }, inverseJoinColumns = {
                    @JoinColumn(name = "LanguageId")
            })
    public List<Language> getTeachingLanguageList()
    {
        return this.teachingLanguageList;
    }

    public void setTeachingLanguageList(List<Language> teachingLanguageList)
    {
        this.teachingLanguageList = teachingLanguageList;
    }

    // bi-directional many-to-many association to Role
    @ManyToMany(fetch = FetchType.EAGER)
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