package vn.edu.fpt.mola.bom.repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import vn.edu.fpt.mola.bom.entity.Course;


@Repository
public class InMemoryCourseRepository implements CourseRepository
{
    private final Map<Integer, Course> database = new Hashtable<>();
    private volatile int courseIdSequense = 1;

    @Override
    public Course get(int id)
    {
        return database.get(id);
    }

    @Override
    public List<Course> getByAuthor(int id)
    {
        ArrayList<Course> list = new ArrayList<>(this.database.values());
        list.removeIf(c -> c.getAuthor().getId() != id);
        return list;
    }

    @Override
    public void add(Course course)
    {
        course.setId(getNextCourseId());
        this.database.put(course.getId(), course);
    }

    @Override
    public void update(Course course)
    {
        this.database.put(course.getId(), course);
    }

    private synchronized int getNextCourseId()
    {
        return this.courseIdSequense++;
    }
}
