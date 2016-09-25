package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * The primary key class for the enroll database table.
 * 
 */
@Embeddable
public class EnrollPK implements Serializable
{
    // default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;
    private long userId;
    private long courseId;

    public EnrollPK()
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

    public boolean equals(Object other)
    {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnrollPK)) {
            return false;
        }
        EnrollPK castOther = (EnrollPK) other;
        return this.userId == castOther.userId
                && this.courseId == castOther.courseId;
    }

    public int hashCode()
    {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + Long.hashCode(this.userId);
        hash = hash * prime + Long.hashCode(this.courseId);

        return hash;
    }
}