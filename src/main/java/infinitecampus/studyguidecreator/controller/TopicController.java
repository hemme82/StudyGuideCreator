package infinitecampus.studyguidecreator.controller;



import infinitecampus.studyguidecreator.model.Topic;
import infinitecampus.studyguidecreator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

//import com.text.testing.service.TopicService;
//import com.text.testing.service.TopicService;

@Controller
public class TopicController {

    @Autowired
    private TopicService topicService;


    @GetMapping("/topics")
    public String listTopics(ModelMap model) {


        List<Topic> topics = (List<Topic>) topicService.getAllTopics();

        model.addAttribute("topics", topics);
        return "index";
    }

    @GetMapping("/topics/{topicId}")
    public String getTopic(@PathVariable Long topicId,
                           ModelMap model, HttpServletResponse response) throws IOException {
        Optional<Topic> topicOptional = topicService.findTopicById(topicId);

        if (topicOptional.isPresent()) {
            Topic topic = topicOptional.get();
            model.put("topic", topic);
//            model.put("tabItems", topic.getTabItems());

        } else {
            response.sendError(HttpStatus.NOT_FOUND.value(), "Topic with id " + topicId + " was not found" );
//            throw new NotFoundException("Topic with id " + topicId + " was not found");
            return "topic";
        }

//        Topic topic = topicService.findTopicById(topicId).orElseThrow(new NotFoundException(
//                "Could not find " +
//                "object with id: " + id));


        return"topic";
    }
    @GetMapping("/topicform")
    public String topicForm(){
//            @RequestBod Topic topic) {
        return "topicform";
    }

    @PostMapping("/addtopic")
    public String addTopic(Topic topic) {
        topicService.saveTopic(topic);
        return "redirect:/topics/"+topic.getId();
    }
    //work in progress
    @PostMapping("/topics/{topicId}")
    public String updateTopic(@PathVariable Long topicId, Topic topic){
        System.out.println(topic);
        return "redirect:/topics/"+topic.getId();
    }


}
