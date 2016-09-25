package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Meeting implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long id;
    private UserPrincipal learner;
    private UserPrincipal teacher;
    private Course course;
    private Lesson lesson;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LearnerId")
    public UserPrincipal getLearner()
    {
        return learner;
    }

    public void setLearner(UserPrincipal learner)
    {
        this.learner = learner;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TeacherId")
    public UserPrincipal getTeacher()
    {
        return teacher;
    }

    public void setTeacher(UserPrincipal teacher)
    {
        this.teacher = teacher;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CourseId")
    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LessonId")
    public Lesson getLesson()
    {
        return lesson;
    }

    public void setLesson(Lesson lesson)
    {
        this.lesson = lesson;
    }

}
