package com.example.msassignment.bl;

import com.example.msassignment.dao.*;
import com.example.msassignment.dto.*;
import com.example.msassignment.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AssignmentBl {
    @Autowired
    private AssignmentRepository assignmentRepository;
    private QuestionRepository questionRepository;
    private QuestionOptionRepository questionOptionRepository;
    private StartEvaluationRepository startEvaluationRepository;

    private StudentAnswerRepository studentAnswerRepository;

    private final Logger logger = LoggerFactory.getLogger(AssignmentBl.class);

    public void createAssignment(AssignmentDto assignmentDto ) {
        logger.info("create Assignment");

        AssignmentEntity assignmentEntity = getAssignmentEntity(assignmentDto);

        assignmentRepository.saveAndFlush(assignmentEntity);

        for(QuestionDto questionDto : assignmentDto.getQuestions()){
            QuestionEntity questionEntity = new QuestionEntity();
            questionEntity.setAssignmentId(assignmentEntity);
            questionEntity.setContent(questionDto.getContent());
            questionEntity.setScore(questionDto.getScore());
            questionRepository.saveAndFlush(questionEntity);
            for(QuestionOptionDto questionOptionDto : questionDto.getOptions()){
                QuestionOptionEntity questionOptionEntity = new QuestionOptionEntity();
                questionOptionEntity.setQuestionId(questionEntity);
                questionOptionEntity.setOption(questionOptionDto.getOption());
                questionOptionEntity.setCorrect(questionOptionDto.isCorrect());
                questionRepository.saveAndFlush(questionEntity);
            }
        }


    }

    private static AssignmentEntity getAssignmentEntity(AssignmentDto assignmentDto) {
        AssignmentEntity assignmentEntity = new AssignmentEntity();
        CourseEntity courseEntity = new CourseEntity();
        SectionEntity sectionEntity = new SectionEntity();

        sectionEntity.setSectionId((long) assignmentDto.getSectionId());
        courseEntity.setCourseId((long) assignmentDto.getCourseId());
        AssignmentTypeEntity assignmentTypeEntity = new AssignmentTypeEntity();
        assignmentTypeEntity.setAssignmentTypeId((long) assignmentDto.getAssignmentTypeId());

        assignmentEntity.setTitle(assignmentDto.getTitle());
        assignmentEntity.setAssignmentTypeId(assignmentTypeEntity);
        assignmentEntity.setStartDate(new Date());
        assignmentEntity.setCourseId(courseEntity);
        assignmentEntity.setSectionId(sectionEntity);
        return assignmentEntity;
    }


    public void completeAssignment(Long id,String userId){
        logger.info("Starting Assignment from user id:"+ userId);
        StartEvaluationEntity startEvaluationEntity = new StartEvaluationEntity();
        AssignmentEntity assignmentEntity = new AssignmentEntity();
        assignmentEntity.setAssignmentId(id);

        startEvaluationEntity.setAssignmentId(assignmentEntity);
        startEvaluationEntity.setKeycloakId(userId);
        startEvaluationEntity.setStartDate(new Date());
        startEvaluationEntity.setCompleted(true);
        startEvaluationRepository.saveAndFlush(startEvaluationEntity);

    }

    public void saveAnswers(Long id, List<StudentAnswerDto> studentAnswerDtos){
        logger.info("Saving answers for assignment id:"+ id);
        for(StudentAnswerDto studentAnswerDto : studentAnswerDtos){
            StudentAnswerEntity studentAnswerEntity = new StudentAnswerEntity();
            QuestionOptionEntity questionOptionEntity = new QuestionOptionEntity();
            questionOptionEntity.setOptionId((long) studentAnswerDto.getOptionId());
            AssignmentEntity assignmentEntity = new AssignmentEntity();
            assignmentEntity.setAssignmentId(id);

            studentAnswerEntity.setAssignmentId(assignmentEntity);
            studentAnswerEntity.setKeycloakId(studentAnswerDto.getKeycloakId());
            studentAnswerEntity.setOptionId(questionOptionEntity);
            studentAnswerEntity.setDate(new Date());

            studentAnswerRepository.saveAndFlush(studentAnswerEntity);
        }
    }


    public List<AssignmentDto> getAllAssignmentsByCourseId(Long courseId){
        logger.info("Getting assignments by course id:"+ courseId);
        List<AssignmentDto> assignments=  new ArrayList<>();
        List<AssignmentEntity> assignmentEntities = assignmentRepository.findAllByCourseId(courseId);
        for(AssignmentEntity assignmentEntity : assignmentEntities){

            AssignmentDto assignmentDto = new AssignmentDto();
            assignmentDto.setId(assignmentEntity.getAssignmentId());
            assignmentDto.setTitle(assignmentEntity.getTitle());
            assignmentDto.setStartDate(assignmentEntity.getStartDate());
            assignmentDto.setCourseId(assignmentEntity.getCourseId().getCourseId());
            assignmentDto.setSectionId(assignmentEntity.getSectionId().getSectionId());
            assignmentDto.setAssignmentTypeId(assignmentEntity.getAssignmentTypeId().getAssignmentTypeId());

            List<QuestionDto> questions = new ArrayList<>();
            List<QuestionEntity> questionEntities = questionRepository.findAllByAssignmentId(assignmentEntity.getAssignmentId());
            
            for(QuestionEntity questionEntity : questionEntities){

                QuestionDto questionDto = new QuestionDto();

                questionDto.setId(questionEntity.getQuestionId());
                questionDto.setContent(questionEntity.getContent());
                questionDto.setScore(questionEntity.getScore());
                questionDto.setAssignmentId(questionEntity.getAssignmentId().getAssignmentId());

                List<QuestionOptionDto> questionOptionDtos = new ArrayList<>();
                List<QuestionOptionEntity> questionOptionEntities = questionOptionRepository.findAllByQuestionId(questionEntity.getQuestionId());

                for(QuestionOptionEntity questionOptionEntity : questionOptionEntities){

                    QuestionOptionDto questionOptionDto = new QuestionOptionDto();

                    questionOptionDto.setId(questionOptionEntity.getOptionId());
                    questionOptionDto.setOption(questionOptionEntity.getOption());
                    questionOptionDto.setCorrect(questionOptionEntity.isCorrect());
                    questionOptionDtos.add(questionOptionDto);
                }
                questionDto.setOptions(questionOptionDtos);
                questions.add(questionDto);
            }
            assignmentDto.setQuestions(questions);
            assignments.add(assignmentDto);
        }
        return assignments;
    }


    public ScoreDto getScore(Long assignmentId, String userId){
        logger.info("Getting score for assignment id:"+ assignmentId);
        ScoreDto scoreDto = new ScoreDto();
        scoreDto.setScore(studentAnswerRepository.findTotalScoreByKeycloakIdAndAssignmentId(userId,assignmentId));
        scoreDto.setMaxScore(studentAnswerRepository.findMaxScoreByAssignmentId(assignmentId));
        return scoreDto;
    }

}
