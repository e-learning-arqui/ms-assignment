package com.example.msassignment.api;

import com.example.msassignment.bl.AssignmentBl;
import com.example.msassignment.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assignment")
public class AssignmentApi {
    @Autowired
    private AssignmentBl assignmentBl;

    //crear un assignment

    @PostMapping
    public ResponseDto<String> createAssignment(@RequestBody AssignmentDto assignmentDto) {
        ResponseDto<String> response = new ResponseDto<>();
        try {
            System.out.println("assignmentDto: " + assignmentDto.toString());
            assignmentBl.createAssignment(assignmentDto);
            response.setCode("0000");
            response.setResponse("Assignment created successfully");
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }
    }

    //marcar un assignment como completado por un usuario

    @PutMapping("/{id}/user/{userId}")
    public ResponseDto<String> completeAssignment(@PathVariable Long id, @PathVariable String userId) {
        ResponseDto<String> response = new ResponseDto<>();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
        try {
            assignmentBl.completeAssignment(id,userId);
            response.setCode("0000");
            response.setResponse("Assignment completed successfully");
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }
    }

    //guardar las respuestas de un usuario a un assignment

    @PostMapping("/{assignmentId}")
    public ResponseDto<String> saveStudentAnswer(@PathVariable Long assignmentId, @RequestBody List<StudentAnswerDto> answers) {
        ResponseDto<String> response = new ResponseDto<>();
        try {
            assignmentBl.saveAnswers(assignmentId,answers);
            response.setCode("0000");
            response.setResponse("Assignment assigned successfully");
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }
    }

    //obtener todos los assignments de un curso

    @GetMapping("/all/{courseId}")
    public ResponseDto<List<AssignmentListDto>> getAllAssignmentsByCourseId(@PathVariable Long courseId) {
        ResponseDto<List<AssignmentListDto>> response = new ResponseDto<>();
        try {
            response.setCode("0000");
            response.setResponse(assignmentBl.getAllAssignmentsByCourseId(courseId));
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }
    }

    //obtener todos el score de un usuario en un assignment
    @GetMapping("/{id}/score/user/{userId}")
    public ResponseDto<ScoreDto> getScore(@PathVariable Long id, @PathVariable String userId) {
        ResponseDto<ScoreDto> response = new ResponseDto<>();
        try {
            response.setCode("0000");
            response.setResponse(assignmentBl.getScore(id,userId));
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }

    }

    // verificacion si un estudiante ya inicio un assignment

    @GetMapping("/{id}/user/{userId}")
    public ResponseDto<Boolean> isAssignmentStarted(@PathVariable Long id, @PathVariable String userId) {
        ResponseDto<Boolean> response = new ResponseDto<>();
        try {
            response.setCode("0000");
            response.setResponse(assignmentBl.isAssignmentCompleted(id,userId));
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }

    }



}
