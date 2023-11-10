package com.automotive.service.impl;

import com.automotive.mapper.AutoMapper;
import com.automotive.models.dto.AutoDTO;
import com.automotive.repository.AutoRepository;
import com.automotive.service.AutoService;
import com.automotive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;
    private final AutoMapper autoMapper;
    private final UserService userService;


    @Override
    public void addAuto(AutoDTO autoDTO) {
        var autoEntity = autoMapper.toModel(autoDTO);
        var loggedInUser = userService.getLoggedInUsser();
        autoEntity.setOwnedBy(loggedInUser);
        autoRepository.save(autoEntity);
    }
}
