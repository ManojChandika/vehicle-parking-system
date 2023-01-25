package com.example.vehiclemanagementsystem.controller;

import com.example.vehiclemanagementsystem.dto.FloorDTO;
import com.example.vehiclemanagementsystem.repo.FloorRepository;
import com.example.vehiclemanagementsystem.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/floors")
public class FloorController {
    @Autowired
    private FloorService floorService;
    @Autowired
    private FloorRepository floorRepository;

    // Add Floor
    @PostMapping
    public ResponseEntity<FloorDTO> createFloor(@RequestBody FloorDTO floorDTO){
        return new ResponseEntity<>(floorService.createFloors(floorDTO), HttpStatus.CREATED);
    }

    // Get All Floors
    @GetMapping
    public ResponseEntity<List<FloorDTO>> getAllFloors(){
        return ResponseEntity.ok(floorService.getAllFloors());
    }

    // Get Floor by id
    @GetMapping("/{id}")
    public ResponseEntity<FloorDTO> getFloorById(@PathVariable(value ="id") Long id){
        return ResponseEntity.ok(floorService.getFloorById(id));
    }

    //Update Floor by id
    @PutMapping("/{id}")
    public ResponseEntity<FloorDTO> updateFloor(
            @RequestBody FloorDTO floorDTO,
            @PathVariable(value = "id") Long id
    ){
        return ResponseEntity.ok(floorService.updateFloor(floorDTO,id));
    }

    // Delete Floor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFloor(@PathVariable(value = "id") Long id){
        floorService.deleteFloor(id);
        return ResponseEntity.ok("Delete Success");
    }

}
