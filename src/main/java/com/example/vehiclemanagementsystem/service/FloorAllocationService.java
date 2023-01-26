package com.example.vehiclemanagementsystem.service;

import com.example.vehiclemanagementsystem.dto.FloorAllocationDTO;
import com.example.vehiclemanagementsystem.entity.Floor;

import java.util.List;

public interface FloorAllocationService {
    FloorAllocationDTO createFloorAllocation(FloorAllocationDTO floorAllocationDTO, Long floorId);
    List<FloorAllocationDTO> getAllFloorAllocationByFloorId(Long floorId);
    FloorAllocationDTO updateFloorAllocationById(Long floorId,Long floorAllocationId, FloorAllocationDTO floorAllocationDTO);
    void deleteFloorAllocationById(Long floorId,Long floorAllocationId);

}
