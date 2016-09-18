package vn.edu.fpt.mola.bom.service;

import java.util.List;

import vn.edu.fpt.mola.bom.entity.Course;


public interface CourseService
{
    List<Course> getCourseByAuthor(int id);

    void saveCourse(int authorId, Course course);
}
