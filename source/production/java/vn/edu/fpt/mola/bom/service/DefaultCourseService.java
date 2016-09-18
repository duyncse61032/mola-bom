package vn.edu.fpt.mola.bom.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import vn.edu.fpt.mola.bom.entity.Course;
import vn.edu.fpt.mola.bom.entity.MolaUser;
import vn.edu.fpt.mola.bom.repository.CourseRepository;
import vn.edu.fpt.mola.bom.repository.MolaUserRepository;


@Service
public class DefaultCourseService implements CourseService
{
    @Inject
    CourseRepository courseRepository;
    @Inject
    MolaUserRepository molaUserRepository;
    @Inject
    NotificationService notificationService;

    @Override
    public List<Course> getCourseByAuthor(int id)
    {
        List<Course> list = this.courseRepository.getByAuthor(id);
        list.sort((c1, c2) -> c1.getId() < c2.getId() ? -1 : 1);
        return list;
    }

    @Override
    public void saveCourse(int authorId, Course course)
    {
        MolaUser user = this.molaUserRepository.get(authorId);
        if (course.getId() < 1) {
            user.getCourseList().add(course);
            course.setAuthor(user);
            this.courseRepository.add(course);
        } else {
            this.courseRepository.update(course);
        }
        // Send notification
        Set<String> recipients = new HashSet<>();
        for (MolaUser u : user.getFollower()) {
            recipients.add(u.getEmail());
        }
        this.notificationService.sendNotification("Course Update",
                user.getName() + " add/update course " + course.getTitle(),
                recipients);
    }

}
