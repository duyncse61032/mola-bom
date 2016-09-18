package vn.edu.fpt.mola.bom.repository;

import java.util.List;

import vn.edu.fpt.mola.bom.entity.Course;


public interface CourseRepository
{
    Course get(int id);

    List<Course> getByAuthor(int id);

    void add(Course course);

    void update(Course course);
}
