package infinitecampus.studyguidecreator.repository;


import infinitecampus.studyguidecreator.model.TabItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TabItemRepository extends CrudRepository<TabItem, Long> {

    //derived query: needs to start with "findBy" then the field
    public List<TabItem> findAllByTopicId(Long Id);
}
