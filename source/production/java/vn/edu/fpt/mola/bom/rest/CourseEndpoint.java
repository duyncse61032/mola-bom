package vn.edu.fpt.mola.bom.rest;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import vn.edu.fpt.mola.bom.config.annotation.RestEndpoint;
import vn.edu.fpt.mola.bom.entity.Course;
import vn.edu.fpt.mola.bom.entity.view.CourseList;
import vn.edu.fpt.mola.bom.service.CourseService;


@RestEndpoint
public class CourseEndpoint
{
    @Inject
    CourseService courseService;

    @RequestMapping(value = "/user/{userId}/course", method = RequestMethod.GET)
    @ResponseBody
    public CourseList read(@PathVariable("userId") long userId)
    {
        CourseList list = new CourseList();
        list.setCourses(this.courseService.getCourseByAuthor(userId));
        return list;
    }

    @RequestMapping(value = "user/{userId}/course/{id}",
            method = RequestMethod.GET)
    @ResponseBody
    public Course read(@PathVariable("userId") long userId,
            @PathVariable("id") long id)
    {
        return this.courseService.get(id);
    }

    @RequestMapping(value = "user/{userId}/course",
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable("userId") long userId,
            @RequestBody @Valid Course course)
    {
        this.courseService.saveCourse(userId, course);;
    }
}
