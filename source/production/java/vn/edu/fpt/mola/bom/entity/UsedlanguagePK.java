package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * The primary key class for the usedlanguage database table.
 * 
 */
@Embeddable
public class UsedlanguagePK implements Serializable
{
    // default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;
    private long userId;
    private long languageId;

    public UsedlanguagePK()
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
    public long getLanguageId()
    {
        return this.languageId;
    }

    public void setLanguageId(long languageId)
    {
        this.languageId = languageId;
    }

    public boolean equals(Object other)
    {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UsedlanguagePK)) {
            return false;
        }
        UsedlanguagePK castOther = (UsedlanguagePK) other;
        return this.userId == castOther.userId
                && this.languageId == castOther.languageId;
    }

    public int hashCode()
    {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + Long.hashCode(this.userId);
        hash = hash * prime + Long.hashCode(this.languageId);

        return hash;
    }
}