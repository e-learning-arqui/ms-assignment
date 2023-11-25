package com.example.msassignment.api;

import com.example.msassignment.bl.ProgressBl;
import com.example.msassignment.dto.ProgressDto;
import com.example.msassignment.dto.ResponseDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/progress")
public class ProgressApi {

    @Autowired
    private ProgressBl progressBl;
    @GetMapping("/{courseId}/student/{kcId}")
    public ResponseEntity<ResponseDto<ProgressDto>> getProgressByCourseIdAndKcId
            (@PathVariable Long courseId,
             @PathVariable String kcId) {
        return ResponseEntity.ok(new ResponseDto<>("0000",  progressBl.progressByCourseIdAndKcId(courseId, kcId), null));
    }
}
