package infinitecampus.studyguidecreator.service;


import infinitecampus.studyguidecreator.model.TabItem;
import infinitecampus.studyguidecreator.model.Topic;
import infinitecampus.studyguidecreator.repository.TabItemRepository;
import infinitecampus.studyguidecreator.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabItemService {
    @Autowired
    private TabItemRepository tabItemRepository;
    @Autowired
    private TopicRepository topicRepository;

    // TODO: 4/9/2019 add getAllTabItems by topic ID
    public List<TabItem> getAllTabItemsByTopicId(Long id){
        List<TabItem> tabs = new ArrayList<>();
        tabItemRepository.findAllByTopicId(id).forEach(tabs::add);
        return tabs;
    }

    public void saveTabItem(TabItem tabItem) {
        Topic topic = topicRepository.findById(tabItem.getTopic().getId()).orElse(null);
//        Topic topic =
//                topicRepository.findById(tabItem.getTopic().getId()).orElse(null);
        tabItem.setTopic(topic);

        tabItemRepository.save(tabItem);
    }

    public List<TabItem> getAllTabItems() {
        List<TabItem> tabItems = new ArrayList<>();
        tabItemRepository.findAll().forEach(tabItems::add);
        return tabItems;
    }
}


