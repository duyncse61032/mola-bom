package vn.edu.fpt.mola.bom.entity;

import java.time.Instant;

import javax.persistence.Basic;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vn.edu.fpt.mola.bom.entity.converter.InstantConverter;
import vn.edu.fpt.mola.bom.entity.enumerate.CourseStatus;
import vn.edu.fpt.mola.bom.entity.enumerate.Degree;

@Entity
public class Course
{
    private int id;
    private String title;
    private String topic;
    private Degree degree;
    private String description;
    private Instant createDate;
    private Instant publishDate;
    private CourseStatus state;
    private UserPrincipal author;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
    public String getTopic()
    {
        return topic;
    }

    public void setTopic(String topic)
    {
        this.topic = topic;
    }

    @Enumerated(EnumType.STRING)
    public Degree getDegree()
    {
        return degree;
    }

    public void setDegree(Degree degree)
    {
        this.degree = degree;
    }

    @Basic
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Convert(converter = InstantConverter.class)
    public Instant getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Instant createDate)
    {
        this.createDate = createDate;
    }

    @Convert(converter = InstantConverter.class)
    public Instant getPublishDate()
    {
        return publishDate;
    }

    public void setPublishDate(Instant publishDate)
    {
        this.publishDate = publishDate;
    }

    @Enumerated(EnumType.STRING)
    public CourseStatus getState()
    {
        return state;
    }

    public void setState(CourseStatus state)
    {
        this.state = state;
    }

    @XmlTransient
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "AuthorId")
    public UserPrincipal getAuthor()
    {
        return author;
    }

    public void setAuthor(UserPrincipal author)
    {
        this.author = author;
    }

}
