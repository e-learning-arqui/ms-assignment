package com.example.msassignment.bl;

import com.example.msassignment.dao.AssignmentRepository;
import com.example.msassignment.dao.AssignmentTypeRepository;
import com.example.msassignment.dto.AssignmentTypeDto;
import com.example.msassignment.entity.AssignmentTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentTypeBl {
    @Autowired
    private AssignmentTypeRepository assignmentTypeRepository;

    public List<AssignmentTypeDto> getAllAssignmentTypes() {
        List<AssignmentTypeEntity> assignmentTypeEntityList = assignmentTypeRepository.findAll();
        List<AssignmentTypeDto> assignmentTypeDtoList = new ArrayList<>();
        for (AssignmentTypeEntity assignmentTypeEntity : assignmentTypeEntityList) {
            AssignmentTypeDto assignmentTypeDto = new AssignmentTypeDto();
            assignmentTypeDto.setId(assignmentTypeEntity.getAssignmentTypeId());
            assignmentTypeDto.setDescription(assignmentTypeEntity.getDescription());
            assignmentTypeDtoList.add(assignmentTypeDto);
        }
        return assignmentTypeDtoList;
    }
}
