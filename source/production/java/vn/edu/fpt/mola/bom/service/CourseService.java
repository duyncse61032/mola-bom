package vn.edu.fpt.mola.bom.service;

import java.util.List;

import vn.edu.fpt.mola.bom.entity.Course;


public interface CourseService
{
    Course get(long id);
    List<Course> getCourseByAuthor(long id);
    void saveCourse(long authorId, Course course);
}
