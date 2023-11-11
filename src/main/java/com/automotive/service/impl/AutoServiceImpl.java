package com.automotive.service.impl;

import com.automotive.mapper.AutoMapper;
import com.automotive.models.dto.AutoDTO;
import com.automotive.repository.AutoRepository;
import com.automotive.service.AutoService;
import com.automotive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;
    private final AutoMapper autoMapper;
    private final UserService userService;


    @Override
    public void saveAuto(AutoDTO autoDTO) {
        var autoEntity = autoMapper.toModel(autoDTO);
        var loggedInUser = userService.getLoggedInUsser();
        autoEntity.setOwnedBy(loggedInUser);
        autoRepository.save(autoEntity);
    }

    @Override
    public List<AutoDTO> getAll() {
        var loggedInUser = userService.getLoggedInUsser();
        var autos = autoRepository.findByUser(loggedInUser.getId());
        return autoMapper.toDtoList(autos);
    }

    @Override
    public AutoDTO getOne(Integer id) {
        var auto = autoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not able to find auto with id " + id));
        return autoMapper.toDto(auto);
    }
}
