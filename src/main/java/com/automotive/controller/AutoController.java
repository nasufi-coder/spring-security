package com.automotive.controller;

import com.automotive.models.MessageResponse;
import com.automotive.models.dto.AutoDTO;
import com.automotive.service.AutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auto")
@AllArgsConstructor
public class AutoController {

    private AutoService autoService;

    @PostMapping("/save")
    public ResponseEntity<?> register(@RequestBody AutoDTO autoDTO) throws Exception {
        autoService.saveAuto(autoDTO);
        return ResponseEntity
                .ok()
                .body(new MessageResponse("Auto is successfully added!"));
    }

    @PostMapping("/free/{id}")
    public ResponseEntity<?> freeAuto(@PathVariable Integer id) {
        autoService.freeAuto(id);
        return ResponseEntity
                .ok()
                .body(new MessageResponse("Auto is ready to be booked!"));
    }

    @GetMapping("/client/all")
    public ResponseEntity<List<AutoDTO>> getMyAll() throws Exception {
        return ResponseEntity.ok(autoService.getMyAll());
    }

    @GetMapping("/all")
    public ResponseEntity<List<AutoDTO>> getAll() throws Exception {
        return ResponseEntity.ok(autoService.getAll());
    }

    @GetMapping("/{id}")
    public AutoDTO getOne(@PathVariable Integer id) throws Exception {
        return autoService.getOne(id);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteAuto(@PathVariable Integer id) {
        autoService.deleteOne(id);
        return ResponseEntity
                .ok()
                .body(new MessageResponse(String.format("Auto with id {} is successfully deleted!", id)));
    }
}
