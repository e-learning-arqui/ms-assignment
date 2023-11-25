package com.example.msassignment.consumer;


import com.example.msassignment.bl.ProgressBl;
import com.example.msassignment.dao.CourseRepository;
import com.example.msassignment.dao.ProgressRepository;
import com.example.msassignment.dao.StudentRepository;
import com.example.msassignment.dto.ProgressMessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ProgressMessageConsumer {


    @Autowired
    private ProgressBl progressBl;

    Logger log = Logger.getLogger(ProgressMessageConsumer.class.getName());
    @RabbitListener(queues = "progress.queue")
    public void consumeProgressMessage(ProgressMessageDto message) {


        log.info("Message recieved from keycloak user id:  " + message.getUserKeyCloakId());

        progressBl.updateProgress(message);
    }
}
