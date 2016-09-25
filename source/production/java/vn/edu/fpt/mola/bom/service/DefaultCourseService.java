package vn.edu.fpt.mola.bom.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.edu.fpt.mola.bom.entity.Course;
import vn.edu.fpt.mola.bom.entity.UserPrincipal;
import vn.edu.fpt.mola.bom.exception.ResourceNotFoundException;
import vn.edu.fpt.mola.bom.repository.CourseRepository;
import vn.edu.fpt.mola.bom.repository.UserRepository;


@Service
public class DefaultCourseService implements CourseService
{
    @Inject
    CourseRepository courseRepository;
    @Inject
    UserRepository userRepository;
    @Inject
    NotificationService notificationService;

    @Override
    public Course get(long id)
    {
        return this.courseRepository.findOne(id);
    }
    @Override
    @Transactional
    public List<Course> getCourseByAuthor(long id)
    {
        Iterable<Course> iterable = this.courseRepository.getByAuthor_Id(id);
        List<Course> list = new ArrayList<Course>();
        for (Course course : iterable) {
            list.add(course);
        }
        
        return list;
    }

    @Override
    @Transactional
    public void saveCourse(long authorId, Course course)
    {
        UserPrincipal user = this.userRepository.findOne(authorId);
        if (course.getId() < 1) {
            user.addCourse(course);
            course.setCreateDate(Instant.now());
            this.courseRepository.save(course);
        } else {
            this.courseRepository.save(course);
        }
        // Send notification
//        Set<String> recipients = new HashSet<>();
//        for (UserPrincipal u : user.getFollowerList()) {
//            recipients.add(u.getDisplayName());
//        }
//        this.notificationService.sendNotification("Course Update",
//                user.getName() + " add/update course " + course.getTitle(),
//                recipients);
    }
}
