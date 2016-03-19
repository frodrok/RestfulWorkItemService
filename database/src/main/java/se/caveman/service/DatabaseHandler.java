package se.caveman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.caveman.model.jpa.JpaUser;
import se.caveman.model.jpa.JpaWorkItem;
import se.caveman.repository.UserRepository;
import se.caveman.repository.WorkItemRepository;

@Service
public class DatabaseHandler {

    @Autowired
    private WorkItemRepository workItemRepository;

    @Autowired
    private UserRepository userRepository;

    public DatabaseHandler() {}

    public JpaWorkItem save(JpaWorkItem workItem) {
        return workItemRepository.save(workItem);
    }

    public JpaUser save(JpaUser user) {
        return userRepository.save(user);
    }


    public JpaUser findUser(Long id) {
        return userRepository.findOne(id);
    }
}
