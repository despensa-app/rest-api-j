package dev.nmarulo.despensa_app.app.pantry.unity_types.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UnitTypeAdminRes {
    
    private Integer id;
    
    private String name;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
}
