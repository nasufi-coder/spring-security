package com.automotive.service;

import com.automotive.models.dto.AutoDTO;

import java.util.List;

public interface AutoService {

    void saveAuto(AutoDTO autoDTO);

    List<AutoDTO> getAll();

    AutoDTO getOne(Integer id);
}
