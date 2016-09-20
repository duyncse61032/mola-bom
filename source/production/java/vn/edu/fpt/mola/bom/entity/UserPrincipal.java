package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.security.Principal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vn.edu.fpt.mola.bom.entity.converter.InstantConverter;
import vn.edu.fpt.mola.bom.entity.enumerate.Gender;


@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UserPrincipal_Username",
                columnNames = "Username")
})
@Access(AccessType.PROPERTY)
public class UserPrincipal implements Principal, Cloneable, Serializable
{
    private static final long serialVersionUID = 1L;

    private static final String SESSION_ATTRIBUTE_KEY = "vn.edu.fpt.mola.bom.user.principal";

    private long id;
    private String username;
    private byte[] password;

    private String title;
    private String firstName;
    private String lastName;
    private String nameSuffix;
    private String displayName;
    private Gender gender;
    private Instant birthday;
    private Address address;
    private List<Course> courseList = new ArrayList<>();
    // private List<UserPrincipal> followeeList = new ArrayList<>();
    // private List<UserPrincipal> followerList = new ArrayList<>();

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

    @Override
    @Transient
    public String getName()
    {
        return this.username;
    }

    @Basic
    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Basic
    @Column(name = "HashedPassword")
    public byte[] getPassword()
    {
        return this.password;
    }

    public void setPassword(byte[] password)
    {
        this.password = password;
    }

    @Override
    public int hashCode()
    {
        return this.username.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof UserPrincipal &&
                ((UserPrincipal) other).username.equals(this.username);
    }

    @Override
    @SuppressWarnings("CloneDoesntDeclareCloneNotSupportedException")
    protected UserPrincipal clone()
    {
        try {
            return (UserPrincipal) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); // not possible
        }
    }

    @Override
    public String toString()
    {
        return this.username;
    }

    public static Principal getPrincipal(HttpSession session)
    {
        return session == null ? null
                : (Principal) session.getAttribute(SESSION_ATTRIBUTE_KEY);
    }

    public static void setPrincipal(HttpSession session, Principal principal)
    {
        session.setAttribute(SESSION_ATTRIBUTE_KEY, principal);
    }

    @Basic
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Basic
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Basic
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Basic
    public String getNameSuffix()
    {
        return nameSuffix;
    }

    public void setNameSuffix(String nameSuffix)
    {
        this.nameSuffix = nameSuffix;
    }

    @Basic
    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    @Enumerated(EnumType.STRING)
    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    @Convert(converter = InstantConverter.class)
    public Instant getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Instant birthday)
    {
        this.birthday = birthday;
    }

    // bi-directional one-to-one association to Address
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    @XmlTransient
    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Course> getCourseList()
    {
        return courseList;
    }

    public void setCourseList(List<Course> courseList)
    {
        this.courseList = courseList;
    }

    // public List<UserPrincipal> getFolloweeList()
    // {
    // return followeeList;
    // }
    //
    // public void setFolloweeList(List<UserPrincipal> followeeList)
    // {
    // this.followeeList = followeeList;
    // }
    //
    // public List<UserPrincipal> getFollowerList()
    // {
    // return followerList;
    // }
    //
    // public void setFollowerList(List<UserPrincipal> followerList)
    // {
    // this.followerList = followerList;
    // }

}
