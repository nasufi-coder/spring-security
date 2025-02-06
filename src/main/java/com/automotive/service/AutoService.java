package com.automotive.service;

import com.automotive.models.dto.AutoDTO;

import java.util.List;

public interface AutoService {

    Integer saveAuto(AutoDTO autoDTO);

    void freeAuto(Integer autoID);

    List<AutoDTO> getAll();

    List<AutoDTO> getMyAll();

    AutoDTO getOne(Integer id);

    void deleteOne(Integer id);
}
