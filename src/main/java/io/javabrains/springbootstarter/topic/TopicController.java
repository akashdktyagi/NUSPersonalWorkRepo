package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/topics",method = RequestMethod.GET)
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/topics/{id}",method = RequestMethod.GET)
    public Optional<Topic> getTopicById(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(value="/topics", method = RequestMethod.POST)
    public int addTopic(@RequestBody Topic topic){
        try{
            topicService.addTopic(topic);
            return 200;
        }catch(Exception e){
            return 400;
        }
    }

    @RequestMapping(value="/topics/{id}", method = RequestMethod.PUT)
    public int updateTopic(@RequestBody Topic topic, @PathVariable String id){
        try{
            topicService.updateTopic(id, topic);
            return 200;
        }catch(Exception e){
            return 400;
        }
    }

    @RequestMapping(value="/topics/{id}", method = RequestMethod.DELETE)
    public int deleteTopic(@PathVariable String id){
        try{
            topicService.deleteTopic(id);
            return 200;
        }catch(Exception e){
            return 400;
        }
    }
}
