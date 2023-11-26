package com.example.msassignment.service;

import com.example.msassignment.dto.ClassDto;
import com.example.msassignment.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "ms-course")
public interface CourseService {

    @GetMapping("/api/v1/courses/{courseId}/classes/all")
     ResponseEntity<ResponseDto<List<ClassDto>>> getClassesByCourseId
            (@PathVariable Long courseId);

    @GetMapping("/api/v1/courses/{courseId}/classes/count")
    ResponseEntity<ResponseDto<Integer>> countClassesByCourseId(@PathVariable Long courseId);

}
