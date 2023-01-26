package com.example.vehiclemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  boolean availability;
    @OneToMany(
            mappedBy = "floor",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<FloorAllocation> floorAllocation = new HashSet<>();
}
