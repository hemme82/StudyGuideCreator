package infinitecampus.studyguidecreator.service;

import infinitecampus.studyguidecreator.model.Topic;
import infinitecampus.studyguidecreator.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public void saveTopic(Topic topic){

        topicRepository.save(topic);
    }

    public Optional<Topic> findTopicById(Long id){
        return topicRepository.findById(id);

    }
}
