package com.example.msassignment.api;

import com.example.msassignment.bl.AssignmentTypeBl;
import com.example.msassignment.dto.AssignmentTypeDto;
import com.example.msassignment.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assignment-type")
public class AssignmentTypeApi {
    @Autowired
    private AssignmentTypeBl assignmentTypeBl;

    @GetMapping
    public ResponseDto<List<AssignmentTypeDto>> getAllAssignmentTypes() {
        ResponseDto<List<AssignmentTypeDto>> response = new ResponseDto<>();
        try {
            response.setCode("0000");
            response.setResponse(assignmentTypeBl.getAllAssignmentTypes());
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }
    }


}
