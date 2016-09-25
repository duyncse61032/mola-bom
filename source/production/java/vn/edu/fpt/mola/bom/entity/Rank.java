package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Rank implements Serializable
{
    private static final long serialVersionUID = 1L;

    private RankPK id;
    private Lesson lesson;
    private UserPrincipal user;

    @EmbeddedId
    public RankPK getId()
    {
        return id;
    }

    public void setId(RankPK id)
    {
        this.id = id;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LessonId")
    public Lesson getLesson()
    {
        return lesson;
    }

    public void setLesson(Lesson lesson)
    {
        this.lesson = lesson;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    public UserPrincipal getUser()
    {
        return user;
    }

    public void setUser(UserPrincipal user)
    {
        this.user = user;
    }

}
