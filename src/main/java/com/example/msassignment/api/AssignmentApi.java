package com.example.msassignment.api;

import com.example.msassignment.bl.AssignmentBl;
import com.example.msassignment.dto.AssignmentDto;
import com.example.msassignment.dto.ResponseDto;
import com.example.msassignment.dto.ScoreDto;
import com.example.msassignment.dto.StudentAnswerDto;
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

    @PostMapping("/{id}")
    public ResponseDto<String> saveStudentAnswer(@PathVariable Long id, @RequestBody List<StudentAnswerDto> answers) {
        ResponseDto<String> response = new ResponseDto<>();
        try {
            assignmentBl.saveAnswers(id,answers);
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
    public ResponseDto<List<AssignmentDto>> getAllAssignmentsByCourseId(@PathVariable Long courseId) {
        ResponseDto<List<AssignmentDto>> response = new ResponseDto<>();
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
/*
    @GetMapping("/{id}/user/{userId}")
    public ResponseDto<Boolean> isAssignmentStarted(@PathVariable Long id, @PathVariable String userId) {
        ResponseDto<Boolean> response = new ResponseDto<>();
        try {
            response.setCode("0000");
            response.setResponse(assignmentBl.isAssignmentStarted(id,userId));
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }

    }
*/

}
