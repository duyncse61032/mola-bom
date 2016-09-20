package vn.edu.fpt.mola.bom.entity.view;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import vn.edu.fpt.mola.bom.entity.Course;


@XmlRootElement(name = "courses")
public class CourseList
{
    private List<Course> courses;

    @XmlElement(name = "course")
    public List<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }

}
