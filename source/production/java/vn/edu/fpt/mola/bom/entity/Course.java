package vn.edu.fpt.mola.bom.entity;

import java.time.Instant;


public class Course
{
    private MolaUser author;
    private int id;
    private String title;
    private String subject;
    private CourseLevel level;
    private String description;
    private Instant createDate;
    private Instant publishDate;
    private CourseStatus status;

    public MolaUser getAuthor()
    {
        return author;
    }

    public void setAuthor(MolaUser author)
    {
        this.author = author;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public CourseLevel getLevel()
    {
        return level;
    }

    public void setLevel(CourseLevel level)
    {
        this.level = level;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Instant getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Instant createDate)
    {
        this.createDate = createDate;
    }

    public Instant getPublishDate()
    {
        return publishDate;
    }

    public void setPublishDate(Instant publishDate)
    {
        this.publishDate = publishDate;
    }

    public CourseStatus getStatus()
    {
        return status;
    }

    public void setStatus(CourseStatus status)
    {
        this.status = status;
    }

}
