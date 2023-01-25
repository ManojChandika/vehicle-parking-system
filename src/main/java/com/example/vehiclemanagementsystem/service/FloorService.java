package com.example.vehiclemanagementsystem.service;

import com.example.vehiclemanagementsystem.dto.FloorDTO;

import java.util.List;

public interface FloorService {
    FloorDTO createFloors(FloorDTO floorDTO);
    List<FloorDTO> getAllFloors();
    FloorDTO getFloorById(Long id);
    FloorDTO updateFloor(FloorDTO floorDTO,Long id);
    void deleteFloor(Long id);
}
