package vn.edu.fpt.mola.bom.repository;

import org.springframework.data.repository.CrudRepository;

import vn.edu.fpt.mola.bom.entity.Course;


public interface CourseRepository extends CrudRepository<Course, Long>
{
    Iterable<Course> getByAuthor_Id(long id);
}
