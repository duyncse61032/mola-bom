package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vn.edu.fpt.mola.bom.entity.converter.InstantConverter;


/**
 * The persistent class for the enroll database table.
 * 
 */
@Entity
@NamedQuery(name = "Enroll.findAll", query = "SELECT e FROM Enroll e")
public class Enroll implements Serializable
{
    private static final long serialVersionUID = 1L;
    private EnrollPK id;
    private Instant enrollDate;
    private int grade;
    private Course course;
    private UserPrincipal userPrincipal;

    public Enroll()
    {
    }

    @EmbeddedId
    public EnrollPK getId()
    {
        return this.id;
    }

    public void setId(EnrollPK id)
    {
        this.id = id;
    }

    @Convert(converter = InstantConverter.class)
    public Instant getEnrollDate()
    {
        return this.enrollDate;
    }

    public void setEnrollDate(Instant enrollDate)
    {
        this.enrollDate = enrollDate;
    }

    public int getGrade()
    {
        return this.grade;
    }

    public void setGrade(int grade)
    {
        this.grade = grade;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Course
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CourseId")
    public Course getCourse()
    {
        return this.course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    @JsonIgnore
    // bi-directional many-to-one association to UserPrincipal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    public UserPrincipal getUserPrincipal()
    {
        return this.userPrincipal;
    }

    public void setUserPrincipal(UserPrincipal userPrincipal)
    {
        this.userPrincipal = userPrincipal;
    }

}