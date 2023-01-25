package com.example.vehiclemanagementsystem.service.impl;

import com.example.vehiclemanagementsystem.dto.FloorDTO;
import com.example.vehiclemanagementsystem.entity.Floor;
import com.example.vehiclemanagementsystem.exception.ResourceNotFoundException;
import com.example.vehiclemanagementsystem.repo.FloorRepository;
import com.example.vehiclemanagementsystem.service.FloorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FloorRepository floorRepository;

    // Create Floor
    @Override
    public FloorDTO createFloors(FloorDTO floorDTO) {
        Floor floor=mapToEntity(floorDTO);
        Floor newFloor=floorRepository.save(floor);
        return mapToFloorDTO(newFloor);
    }

    // Get all Floors
    @Override
    public List<FloorDTO> getAllFloors() {
        List<Floor> floorList=floorRepository.findAll();
        return floorList.stream().map(floor -> mapToFloorDTO(floor)).collect(Collectors.toList());
    }

    // Get floor by id
    @Override
    public FloorDTO getFloorById(Long id) {
        Floor floor = checkIdAvailability(id);
        return mapToFloorDTO(floor);
    }

    // Update Floor using id
    @Override
    public FloorDTO updateFloor(FloorDTO floorDTO, Long id) {
        Floor floor= checkIdAvailability(id);
        // map to Floor Object
        floor.setName(floorDTO.getName());
        floor.setAvailability(floorDTO.isAvailability());

        Floor updatedFloor = floorRepository.save(floor);
        return mapToFloorDTO(updatedFloor);
    }

    // Delete Floor using id
    @Override
    public void deleteFloor(Long id) {
        Floor floor= checkIdAvailability(id);
        floorRepository.delete(floor);
    }

    // map DTO to Entity
    private Floor mapToEntity(FloorDTO floorDTO){
        Floor floor= modelMapper.map(floorDTO,Floor.class);
        return floor;
    }
    // map Entity to DTO
    private FloorDTO mapToFloorDTO(Floor floor){
        FloorDTO floorDTO = modelMapper.map(floor,FloorDTO.class);
        return floorDTO;
    }

    // Check id availability
    private Floor checkIdAvailability(Long id){
        return floorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Floor", "id", id));
    }
}
