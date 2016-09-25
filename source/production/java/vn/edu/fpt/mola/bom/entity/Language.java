package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

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
    private List<Course> courseList;
    private List<Usedlanguage> usedLanguageList;

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
    // bi-directional many-to-one association to Course
    @OneToMany(mappedBy = "language")
    public List<Course> getCourseList()
    {
        return this.courseList;
    }

    public void setCourseList(List<Course> courseList)
    {
        this.courseList = courseList;
    }

    public Course addCourse(Course course)
    {
        getCourseList().add(course);
        course.setLanguage(this);

        return course;
    }

    public Course removeCourse(Course course)
    {
        getCourseList().remove(course);
        course.setLanguage(null);

        return course;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Usedlanguage
    @OneToMany(mappedBy = "language")
    public List<Usedlanguage> getUsedLanguageList()
    {
        return this.usedLanguageList;
    }

    public void setUsedLanguageList(List<Usedlanguage> usedLanguageList)
    {
        this.usedLanguageList = usedLanguageList;
    }

    public Usedlanguage addUsedLanguage(Usedlanguage usedLanguage)
    {
        getUsedLanguageList().add(usedLanguage);
        usedLanguage.setLanguage(this);

        return usedLanguage;
    }

    public Usedlanguage removeUsedLanguage(Usedlanguage usedLanguage)
    {
        getUsedLanguageList().remove(usedLanguage);
        usedLanguage.setLanguage(null);

        return usedLanguage;
    }

}