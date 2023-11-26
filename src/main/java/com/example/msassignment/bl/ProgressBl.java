package com.example.msassignment.bl;

import com.example.msassignment.dao.ClassRepository;
import com.example.msassignment.dao.CourseRepository;
import com.example.msassignment.dao.ProgressRepository;
import com.example.msassignment.dao.StudentRepository;
import com.example.msassignment.dto.ClassDto;
import com.example.msassignment.dto.ProgressDto;
import com.example.msassignment.dto.ProgressMessageDto;
import com.example.msassignment.dto.ResponseDto;
import com.example.msassignment.entity.ClassEntity;
import com.example.msassignment.entity.CourseEntity;
import com.example.msassignment.entity.ProgressEntity;
import com.example.msassignment.entity.Student;
import com.example.msassignment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Service
public class ProgressBl {

    Logger log = Logger.getLogger(ProgressBl.class.getName());

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProgressRepository progressRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ClassRepository classRepository;


    public void updateProgress(ProgressMessageDto progressMessageDto) {
        //get all classes from course

        ClassEntity classEntity = classRepository.findById(progressMessageDto.getClassId()).orElse(null);

        //get course by id
        CourseEntity courseEntity = courseRepository.findByCourseId(progressMessageDto.getCourseId());
        //get student by keycloak id
        Student studentEntity = studentRepository.findByKeycloakId(progressMessageDto.getUserKeyCloakId());

        ProgressEntity progressEntity = new ProgressEntity();

        assert classEntity != null;
        if(!progressRepository.existsByCourseIdAndKcIdAndClassId(
                courseEntity.getCourseId(),
                studentEntity.getKeycloakId(),
                classEntity.getClassId())){
            progressEntity.setCourseId(courseEntity);
            progressEntity.setActorId(studentEntity);
            progressEntity.setProgressPercent(100.0);
            progressEntity.setClassId(classEntity);
            progressRepository.save(progressEntity);
        }


    }

    public ProgressDto progressByCourseIdAndKcId(Long courseId, String keycloakId){

        Student student = studentRepository.findByKeycloakId(keycloakId);
        log.info("Calculating progress by courseId: " + courseId + " and keycloakId: " + keycloakId);
        int TOTAL_VIDEOS = Objects.requireNonNull(courseService.countClassesByCourseId(courseId).getBody()).getResponse();
        int VIDEOS_WATCHED = progressRepository.classesViewedByKcId(courseId, keycloakId);
        log.info("Total viewed videos: " + VIDEOS_WATCHED);
        log.info("Total videos: " + TOTAL_VIDEOS);

        Double progressPercent = calculateProgress(TOTAL_VIDEOS, VIDEOS_WATCHED);
        log.info("Progress percent: " + progressPercent);
        ProgressDto progressDto = new ProgressDto();

        progressDto.setProgressPercent(progressPercent);
        progressDto.setCourseId(courseId);
        progressDto.setActorId(student.getUserId());
        return progressDto;

    }

    private Double calculateProgress(int totalVideos, int videosWatched){
        Double totalVideosDouble = (double) totalVideos;
        Double videosWatchedDouble = (double) videosWatched;

        return (double) (totalVideosDouble/videosWatchedDouble);
    }

    public ProgressDto findProgressByCourseIdAndKcId(Long courseId, String keycloakId) {
        log.info("Finding progress by courseId: " + courseId + " and keycloakId: " + keycloakId);

        ProgressEntity progressEntity = progressRepository.findByCourseIdAndKcId(courseId, keycloakId);
        ProgressDto progressDto = new ProgressDto();
        progressDto.setActorId(progressEntity.getActorId().getUserId());
        progressDto.setProgressPercent(progressEntity.getProgressPercent());
        progressDto.setProgressId(progressEntity.getProgressId());
        progressDto.setCourseId(progressEntity.getCourseId().getCourseId());
        return progressDto;

    }


}

