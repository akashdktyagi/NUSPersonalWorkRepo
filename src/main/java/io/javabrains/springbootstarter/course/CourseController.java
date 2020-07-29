package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/topics/{topicId}/courses",method = RequestMethod.GET)
    public List<Course> getAllCourses(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping(value = "/topics/{topicId}/course/{courseId}",method = RequestMethod.GET)
    public Optional<Course> getCourseById(@PathVariable String topicId,@PathVariable String courseId){
        return courseService.getCourse(topicId, courseId);
    }

    @RequestMapping(value="/topics/{topicId}/course", method = RequestMethod.POST)
    public int addTopic(@RequestBody Course course,@PathVariable String topicId){
        try{
            Topic topic  = new Topic(topicId,"","");
            course.setTopic(topic);
            courseService.addCourse(course);
            return 200;
        }catch(Exception e){
            return 400;
        }
    }

    @RequestMapping(value="/topics/{topicId}/course/{courseId}", method = RequestMethod.PUT)
    public int updateTopic(@RequestBody Course course, @PathVariable String topicId,@PathVariable String courseId){
        try{
            courseService.updateCourse(topicId,courseId,course);
            return 200;
        }catch(Exception e){
            return 400;
        }
    }

    @RequestMapping(value="/topics/{topicId}/course/{courseId}", method = RequestMethod.DELETE)
    public int deleteTopic(@PathVariable String topicId,@PathVariable String courseId){
        try{
            courseService.deleteCourse(topicId,courseId);
            return 200;
        }catch(Exception e){
            return 400;
        }
    }
}
