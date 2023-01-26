package com.example.vehiclemanagementsystem.repo;

import com.example.vehiclemanagementsystem.entity.FloorAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FloorAllocationRepository extends JpaRepository<FloorAllocation,Long> {
    List<FloorAllocation> findByFloorId(Long floorId);
}
