package com.example.msassignment.api;

import com.example.msassignment.bl.QuestionBl;
import com.example.msassignment.dto.QuestionDto;
import com.example.msassignment.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class QuestionApi {
    @Autowired
    private QuestionBl questionBl;

        @GetMapping("/assignment/{id}/questions")
    public ResponseDto<List<QuestionDto>> getQuestionsByAssignmentId(@PathVariable Long id) {
        ResponseDto<List<QuestionDto>>response = new ResponseDto<>();
        try {
            response.setCode("0000");
            response.setResponse(questionBl.getQuestionsByAssignmentId(id));
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }
    }

}
