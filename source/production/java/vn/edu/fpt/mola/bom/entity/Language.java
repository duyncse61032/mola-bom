package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the language database table.
 * 
 */
@Entity
@NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l")
public class Language implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long id;
    private String englishName;
    private String nativeName;
    private List<UserPrincipal> learnerList;
    private List<UserPrincipal> teacherList;

    public Language()
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

    public String getEnglishName()
    {
        return this.englishName;
    }

    public void setEnglishName(String englishName)
    {
        this.englishName = englishName;
    }

    public String getNativeName()
    {
        return this.nativeName;
    }

    public void setNativeName(String nativeName)
    {
        this.nativeName = nativeName;
    }

    @JsonIgnore
    // bi-directional many-to-many association to UserPrincipal
    @ManyToMany(mappedBy = "learningLanguageList")
    public List<UserPrincipal> getLearnerList()
    {
        return this.learnerList;
    }

    public void setLearnerList(List<UserPrincipal> learnerList)
    {
        this.learnerList = learnerList;
    }

    @JsonIgnore
    // bi-directional many-to-many association to UserPrincipal
    @ManyToMany(mappedBy = "teachingLanguageList")
    public List<UserPrincipal> getTeacherList()
    {
        return this.teacherList;
    }

    public void setTeacherList(List<UserPrincipal> teacherList)
    {
        this.teacherList = teacherList;
    }

}