package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * The primary key class for the rank database table.
 * 
 */
@Embeddable
public class RankPK implements Serializable
{
    private static final long serialVersionUID = 1L;

    private long userId;
    private long courseId;
    private Long lessonId;

    public RankPK()
    {
    }

    @Column(insertable = false, updatable = false)
    public long getUserId()
    {
        return this.userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    @Column(insertable = false, updatable = false)
    public long getCourseId()
    {
        return this.courseId;
    }

    public void setCourseId(long courseId)
    {
        this.courseId = courseId;
    }

    public Long getLessonId()
    {
        return lessonId;
    }

    public void setLessonId(Long lessonId)
    {
        this.lessonId = lessonId;
    }

    public boolean equals(Object other)
    {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RankPK)) {
            return false;
        }
        RankPK castOther = (RankPK) other;
        return this.userId == castOther.userId
                && this.courseId == castOther.courseId
                && (castOther.lessonId == null) ? this.lessonId == null
                        : castOther.lessonId.equals(this.lessonId);
    }

    public int hashCode()
    {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + Long.hashCode(this.userId);
        hash = hash * prime + Long.hashCode(this.courseId);
        hash = hash * prime
                + (this.lessonId == null ? 0 : this.lessonId.hashCode());

        return hash;
    }
}
