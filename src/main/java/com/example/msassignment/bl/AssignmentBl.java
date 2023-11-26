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
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionOptionRepository questionOptionRepository;
    @Autowired
    private StartEvaluationRepository startEvaluationRepository;
    @Autowired
    private StudentAnswerRepository studentAnswerRepository;

    private final Logger logger = LoggerFactory.getLogger(AssignmentBl.class);

    public void createAssignment(AssignmentDto assignmentDto ) {
        logger.info("create Assignment");

        AssignmentEntity assignmentEntity = getAssignmentEntity(assignmentDto);
        assignmentRepository.saveAndFlush(assignmentEntity);

        for(QuestionDto questionDto : assignmentDto.getQuestions()){
            System.out.println(questionDto.getContent());
            QuestionEntity questionEntity = new QuestionEntity();
            questionEntity.setAssignmentId(assignmentEntity);
            questionEntity.setContent(questionDto.getContent());
            questionEntity.setScore(questionDto.getScore());
            questionRepository.saveAndFlush(questionEntity);

            for(QuestionOptionDto questionOptionDto : questionDto.getOptions()){
                System.out.println("*************************************");
                System.out.println(questionOptionDto.getOption());
                System.out.println(questionOptionDto.getIsCorrect());
                System.out.println("*************************************");

                QuestionOptionEntity questionOptionEntity = new QuestionOptionEntity();
                questionOptionEntity.setQuestionId(questionEntity);
                questionOptionEntity.setOption(questionOptionDto.getOption());
                questionOptionEntity.setCorrect(Boolean.valueOf(questionOptionDto.getIsCorrect()));

                questionOptionRepository.saveAndFlush(questionOptionEntity);
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

    public List<AssignmentListDto> getAllAssignmentsByCourseId(Long courseId){
        logger.info("Getting assignments by course id:"+ courseId);
        List<AssignmentListDto> assignments=  new ArrayList<>();
        List<AssignmentEntity> assignmentEntities = assignmentRepository.findAllByCourseId(courseId);
        for(AssignmentEntity assignmentEntity : assignmentEntities){
            AssignmentListDto assignmentListDto = getAssignmentListDto(assignmentEntity);
            assignments.add(assignmentListDto);
        }
        return assignments;
    }

    private static AssignmentListDto getAssignmentListDto(AssignmentEntity assignmentEntity) {
        AssignmentListDto assignmentListDto = new AssignmentListDto();
        assignmentListDto.setId(assignmentEntity.getAssignmentId());
        assignmentListDto.setTitle(assignmentEntity.getTitle());
        assignmentListDto.setStartDate(assignmentEntity.getStartDate());
        assignmentListDto.setCourseId(assignmentEntity.getCourseId().getCourseId());
        assignmentListDto.setSectionId(assignmentEntity.getSectionId().getSectionId());
        assignmentListDto.setAssignmentTypeId(assignmentEntity.getAssignmentTypeId().getAssignmentTypeId());
        return assignmentListDto;
    }
/*

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
                questionDto.setAssignmentId(assignmentEntity.getAssignmentId());

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
*/

    public ScoreDto getScore(Long assignmentId, String userId){
        logger.info("Getting score for assignment id:"+ assignmentId);
        ScoreDto scoreDto = new ScoreDto();
        Integer score = studentAnswerRepository.findTotalScoreByKeycloakIdAndAssignmentId(userId, assignmentId);
        System.out.println("**************************************************");
        System.out.println("score:"+score);
        System.out.println("**************************************************");

        if (score == null) {
            if(studentAnswerRepository.existsByKeycloakIdAndAssignmentId(userId, assignmentId)){
                scoreDto.setScore(0);
            }else{
                scoreDto.setScore(-1);

            }
        } else {
            scoreDto.setScore(score);
        }

        scoreDto.setMaxScore(studentAnswerRepository.findMaxScoreByAssignmentId(assignmentId));
        return scoreDto;
    }


    public Boolean isAssignmentCompleted(Long assignmentId, String userId){
        logger.info("Checking if assignment is completed for assignment id:"+ assignmentId);
        return startEvaluationRepository.hasStartedEvaluation(userId,assignmentId);
    }

}
