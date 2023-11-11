package com.automotive.controller;

import com.automotive.models.MessageResponse;
import com.automotive.models.dto.AutoDTO;
import com.automotive.models.dto.UserDto;
import com.automotive.service.AutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auto")
@AllArgsConstructor
public class AutoController {

    AutoService autoService;

    @PostMapping("/save")
    public ResponseEntity<?> register(@RequestBody AutoDTO autoDTO) throws Exception {
        autoService.saveAuto(autoDTO);
        return ResponseEntity
                .ok()
                .body(new MessageResponse("Auto is successfully added!"));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AutoDTO>> getAll() throws Exception {
        return ResponseEntity.ok(autoService.getAll());
    }

    @GetMapping("/{id}")
    public AutoDTO getUsers(@PathVariable Integer id) throws Exception {
        return autoService.getOne(id);
    }
}
