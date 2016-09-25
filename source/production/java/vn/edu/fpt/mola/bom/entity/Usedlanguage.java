package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vn.edu.fpt.mola.bom.entity.enumerate.LanguageUseFor;


/**
 * The persistent class for the usedlanguage database table.
 * 
 */
@Entity
@NamedQuery(name = "Usedlanguage.findAll",
        query = "SELECT u FROM Usedlanguage u")
public class Usedlanguage implements Serializable
{
    private static final long serialVersionUID = 1L;
    private UsedlanguagePK id;
    private LanguageUseFor useFor;
    private Language language;
    private UserPrincipal userPrincipal;

    public Usedlanguage()
    {
    }

    @EmbeddedId
    public UsedlanguagePK getId()
    {
        return this.id;
    }

    public void setId(UsedlanguagePK id)
    {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public LanguageUseFor getUseFor()
    {
        return this.useFor;
    }

    public void setUseFor(LanguageUseFor useFor)
    {
        this.useFor = useFor;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Language
    @ManyToOne(fetch = FetchType.LAZY)
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