package com.example.msassignment.bl;

import com.example.msassignment.dao.QuestionOptionRepository;
import com.example.msassignment.dao.QuestionRepository;
import com.example.msassignment.dto.QuestionDto;
import com.example.msassignment.dto.QuestionOptionDto;
import com.example.msassignment.entity.QuestionEntity;
import com.example.msassignment.entity.QuestionOptionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionBl {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionOptionRepository questionOptionRepository;
    private final Logger logger = LoggerFactory.getLogger(AssignmentBl.class);


    public List<QuestionDto> getQuestionsByAssignmentId(Long id) {
        logger.info("get Questions By Assignment Id "+ id);
        List<QuestionEntity> questionEntities= questionRepository.findAllByAssignmentId(id);
        List<QuestionDto> questions = new ArrayList<>();

        for(QuestionEntity questionEntity : questionEntities){
            QuestionDto questionDto = new QuestionDto();

            questionDto.setId(questionEntity.getQuestionId());
            questionDto.setContent(questionEntity.getContent());
            questionDto.setScore(questionEntity.getScore());
            questionDto.setAssignmentId(questionEntity.getAssignmentId().getAssignmentId());

            List<QuestionOptionDto> questionOptions = new ArrayList<>();
            List<QuestionOptionEntity> questionOptionEntities = questionOptionRepository.findAllByQuestionId(questionEntity.getQuestionId());

            for(QuestionOptionEntity questionOptionEntity : questionOptionEntities){

                QuestionOptionDto questionOptionDto = new QuestionOptionDto();

                questionOptionDto.setId(questionOptionEntity.getOptionId());
                questionOptionDto.setOption(questionOptionEntity.getOption());
                //questionOptionDto.setIsCorrect("a");
                questionOptions.add(questionOptionDto);
            }
            questionDto.setOptions(questionOptions);
            questions.add(questionDto);
        }
        return questions;
    }

}
