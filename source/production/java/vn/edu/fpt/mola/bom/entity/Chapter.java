package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the chapter database table.
 * 
 */
@Entity
@NamedQuery(name = "Chapter.findAll", query = "SELECT c FROM Chapter c")
public class Chapter implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long id;
    private String description;
    private String title;
    private Course course;
    private List<Lesson> lessonList;

    public Chapter()
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

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
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
    // bi-directional many-to-one association to Lesson
    @OneToMany(mappedBy = "chapter")
    public List<Lesson> getLessonList()
    {
        return this.lessonList;
    }

    public void setLessonList(List<Lesson> lessonList)
    {
        this.lessonList = lessonList;
    }

    public Lesson addLesson(Lesson lesson)
    {
        getLessonList().add(lesson);
        lesson.setChapter(this);

        return lesson;
    }

    public Lesson removeLesson(Lesson lesson)
    {
        getLessonList().remove(lesson);
        lesson.setChapter(null);

        return lesson;
    }

}