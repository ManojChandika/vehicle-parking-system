package com.example.vehiclemanagementsystem.controller;

import com.example.vehiclemanagementsystem.dto.FloorAllocationDTO;
import com.example.vehiclemanagementsystem.service.FloorAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/floors/{floorId}")
public class FloorAllocationController {
    @Autowired
    private FloorAllocationService floorAllocationService;

    // Create Floor Allocation
    @PostMapping("/floorAllocation")
    public ResponseEntity<FloorAllocationDTO> createFloorAllocation(
            @RequestBody FloorAllocationDTO floorAllocationDTO,
            @PathVariable(value = "floorId") Long floorId
    ){
        return new ResponseEntity(floorAllocationService.createFloorAllocation(floorAllocationDTO,floorId), HttpStatus.CREATED);
    }

    // Get floor allocation bt floor id
    @GetMapping("/floorAllocation")
    public ResponseEntity<List<FloorAllocationDTO>> getAllFloorAllocationByFloorId(@PathVariable(value = "floorId") Long floorId){
        return ResponseEntity.ok(floorAllocationService.getAllFloorAllocationByFloorId(floorId));
    }

    // Update floor allocation by id
    @PutMapping("/floorAllocation/{id}")
    public ResponseEntity<FloorAllocationDTO> updateFloorAllocationById(
            @PathVariable(value = "floorId") Long floorId,
            @PathVariable(value = "id") Long floorAllocationId,
            @RequestBody FloorAllocationDTO floorAllocationDTO

    ){
        return ResponseEntity.ok(floorAllocationService.updateFloorAllocationById(floorId,floorAllocationId,floorAllocationDTO));
    }

    // Delete Floor Allocation by id
    @DeleteMapping("/floorAllocation/{id}")
    public ResponseEntity<String> deleteFloorAllocationById(
            @PathVariable(value = "floorId") Long floorId,
            @PathVariable(value = "id") Long floorAllocationId
    ){
        floorAllocationService.deleteFloorAllocationById(floorId,floorAllocationId);
        return ResponseEntity.ok("Floor allocation Delete success");
    }

}
