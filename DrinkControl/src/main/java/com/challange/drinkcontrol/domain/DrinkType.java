package com.challange.drinkcontrol.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrinkType {

    @Id
    private Integer id;
    private String description;
    private Integer capacity;
    private Integer totalStoreged;
    private Integer freeSpace;
}
