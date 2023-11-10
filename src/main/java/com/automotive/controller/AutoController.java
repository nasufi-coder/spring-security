package com.automotive.controller;

import com.automotive.models.MessageResponse;
import com.automotive.models.dto.AutoDTO;
import com.automotive.service.AutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auto")
@AllArgsConstructor
public class AutoController {

    AutoService autoService;

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody AutoDTO autoDTO) throws Exception {
        autoService.addAuto(autoDTO);
        return ResponseEntity
                .ok()
                .body(new MessageResponse("Auto is successfully added!"));
    }
}
