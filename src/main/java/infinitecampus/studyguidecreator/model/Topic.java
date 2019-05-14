package infinitecampus.studyguidecreator.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topicName;

//    @Lob
//    @Column(topicName="desc", length=1024)
    private String topicDescription;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy= "topic")
    List<TabItem> tabItems = new ArrayList<>();

    public Topic() {
    }

    public Topic( String topicName, String description, List<TabItem> tabItems) {
        this.topicName= topicName;
        this.topicDescription = description;
        this.tabItems = tabItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public List<TabItem> getTabItems() {
        return tabItems;
    }

    public void setTabItems(List<TabItem> tabItems) {
        this.tabItems = tabItems;
    }
}
