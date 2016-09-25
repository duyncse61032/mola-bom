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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vn.edu.fpt.mola.bom.entity.converter.InstantConverter;
import vn.edu.fpt.mola.bom.entity.enumerate.CourseStatus;
import vn.edu.fpt.mola.bom.entity.enumerate.Degree;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
public class Course implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long id;
    private Instant createDate;
    private Degree degree;
    private String description;
    private CourseStatus state;
    private String title;
    private String topic;
    private List<Chapter> chapterList;
    private Language language;
    private UserPrincipal author;
    private List<Enroll> enrollList;
    private List<Meeting> meetingList;

    public Course()
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
    public Instant getCreateDate()
    {
        return this.createDate;
    }

    public void setCreateDate(Instant createDate)
    {
        this.createDate = createDate;
    }

    @Enumerated(EnumType.STRING)
    public Degree getDegree()
    {
        return this.degree;
    }

    public void setDegree(Degree degree)
    {
        this.degree = degree;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public CourseStatus getState()
    {
        return this.state;
    }

    public void setState(CourseStatus state)
    {
        this.state = state;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTopic()
    {
        return this.topic;
    }

    public void setTopic(String topic)
    {
        this.topic = topic;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Chapter
    @OneToMany(mappedBy = "course")
    public List<Chapter> getChapterList()
    {
        return this.chapterList;
    }

    public void setChapterList(List<Chapter> chapterList)
    {
        this.chapterList = chapterList;
    }

    public Chapter addChapter(Chapter chapter)
    {
        getChapterList().add(chapter);
        chapter.setCourse(this);

        return chapter;
    }

    public Chapter removeChapter(Chapter chapter)
    {
        getChapterList().remove(chapter);
        chapter.setCourse(null);

        return chapter;
    }

    // bi-directional many-to-one association to Language
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LanguageId")
    public Language getLanguage()
    {
        return this.language;
    }

    public void setLanguage(Language language)
    {
        this.language = language;
    }

    @JsonIgnore
    // bi-directional many-to-one association to UserPrincipal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AuthorId")
    public UserPrincipal getAuthor()
    {
        return this.author;
    }

    public void setAuthor(UserPrincipal author)
    {
        this.author = author;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Enroll
    @OneToMany(mappedBy = "course")
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
        enroll.setCourse(this);

        return enroll;
    }

    public Enroll removeEnroll(Enroll enroll)
    {
        getEnrollList().remove(enroll);
        enroll.setCourse(null);

        return enroll;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Meeting
    @OneToMany(mappedBy = "course")
    public List<Meeting> getMeetingList()
    {
        return this.meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList)
    {
        this.meetingList = meetingList;
    }

    public Meeting addMeeting(Meeting meeting)
    {
        getMeetingList().add(meeting);
        meeting.setCourse(this);

        return meeting;
    }

    public Meeting removeMeeting(Meeting meeting)
    {
        getMeetingList().remove(meeting);
        meeting.setCourse(null);

        return meeting;
    }

}