package infinitecampus.studyguidecreator.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class TabItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tabName;
    private String tabUrl;
    @ManyToOne//cascade =CascadeType.ALL)
    @JoinColumn(name="topic")
    private Topic topic;
    private TypeOfContent typeOfContent;
    private String toolCode;

    public TabItem() {
    }

    public TabItem(@NotNull @Size(min = 3, max = 25) String tabName, @NotNull String tabUrl, TypeOfContent typeOfContent) {
        this.tabName = tabName;
        this.tabUrl = tabUrl;
        this.typeOfContent = typeOfContent;
    }

    public static enum TypeOfContent{
        //TODO: add string value to enum
        DOCUMENT, VIDEO, SIMULATION, OTHER
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getTabUrl() {
        return tabUrl;
    }

    public void setTabUrl(String tabUrl) {
        this.tabUrl = tabUrl;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public TypeOfContent getTypeOfContent() {
        return typeOfContent;
    }

    public void setTypeOfContent(TypeOfContent typeOfContent) {
        this.typeOfContent = typeOfContent;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }
}
