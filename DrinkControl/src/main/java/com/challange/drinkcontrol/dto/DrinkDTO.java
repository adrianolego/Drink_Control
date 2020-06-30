package com.challange.drinkcontrol.dto;

import com.challange.drinkcontrol.service.validation.DrinkUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DrinkUpdate
public class DrinkDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "Required field")
    private Integer amount;
    @NotEmpty(message = "Required field")
    private Integer idSession;
}
