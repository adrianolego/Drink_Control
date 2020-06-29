package com.example.DrinkControl.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrinkAlcoholic extends DrinkBatch {

    private Double alcoholStrength;
}
