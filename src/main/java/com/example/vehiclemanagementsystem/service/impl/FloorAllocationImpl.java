package com.example.vehiclemanagementsystem.service.impl;

import com.example.vehiclemanagementsystem.dto.FloorAllocationDTO;
import com.example.vehiclemanagementsystem.entity.Floor;
import com.example.vehiclemanagementsystem.entity.FloorAllocation;
import com.example.vehiclemanagementsystem.exception.ResourceNotFoundException;
import com.example.vehiclemanagementsystem.repo.FloorAllocationRepository;
import com.example.vehiclemanagementsystem.repo.FloorRepository;
import com.example.vehiclemanagementsystem.service.FloorAllocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FloorAllocationImpl implements FloorAllocationService {
    @Autowired
    private FloorAllocationRepository floorAllocationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FloorRepository floorRepository;

    // Create Floor Allocation
    @Override
    public FloorAllocationDTO createFloorAllocation(FloorAllocationDTO floorAllocationDTO, Long floorId) {
        Floor floor = checkFloorAvailabilityById(floorId);
        FloorAllocation floorAllocation=mapToEntity(floorAllocationDTO);
        floorAllocation.setFloor(floor);
        return mapToDTO(floorAllocationRepository.save(floorAllocation));
    }

    // Get all Floor allocation by floor id
    @Override
    public List<FloorAllocationDTO> getAllFloorAllocationByFloorId(Long floorId) {
        Floor floor = checkFloorAvailabilityById(floorId);
        List<FloorAllocation> floorAllocationList = floorAllocationRepository.findByFloorId(floorId);
        return floorAllocationList.stream().map(floorAllocation -> mapToDTO(floorAllocation)).collect(Collectors.toList());
    }

    // Update floor allocation by id
    @Override
    public FloorAllocationDTO updateFloorAllocationById(Long floorId,Long floorAllocationId, FloorAllocationDTO floorAllocationDTO) {
        Floor floor=checkFloorAvailabilityById(floorId);
        FloorAllocation floorAllocation= checkFloorAllocationAvailabilityById(floorAllocationId);

        floorAllocation.setVehicleType(floorAllocationDTO.getVehicleType());
        floorAllocation.setParkingSlots(floorAllocationDTO.getParkingSlots());
        floorAllocation.setRate(floorAllocationDTO.getRate());

        return mapToDTO(floorAllocationRepository.save(floorAllocation));
    }

    // delete floor allocation by id
    @Override
    public void deleteFloorAllocationById(Long floorId,Long floorAllocationId) {
        Floor floor=checkFloorAvailabilityById(floorId);
        FloorAllocation floorAllocation= checkFloorAllocationAvailabilityById(floorAllocationId);

        floorAllocationRepository.delete(floorAllocation);
    }

    // map DTO to Entity
    private FloorAllocation mapToEntity(FloorAllocationDTO floorAllocationDTO){
        return modelMapper.map(floorAllocationDTO,FloorAllocation.class);
    }

    // map Entity to DTO
    private FloorAllocationDTO mapToDTO(FloorAllocation floorAllocation){
        return modelMapper.map(floorAllocation, FloorAllocationDTO.class);
    }

    // Check Floor id availability and return Object
    private Floor checkFloorAvailabilityById(Long floorId){
        return floorRepository.findById(floorId).orElseThrow(()-> new ResourceNotFoundException("Floor", "id",floorId));
    }

    // check Floor allocation id availability and return Object
    private  FloorAllocation checkFloorAllocationAvailabilityById(Long floorAllocationId){
        return floorAllocationRepository.findById(floorAllocationId).orElseThrow(()-> new ResourceNotFoundException("FloorAllocation", "id",floorAllocationId));
    }

}
