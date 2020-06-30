package com.challange.drinkcontrol.dto;

import com.challange.drinkcontrol.domain.Session;
import com.challange.drinkcontrol.service.validation.SessionUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SessionUpdate
public class SessionDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "Required field")
    @Length(min = 5, max = 20, message = "Min 5 and max 20 characters")
    private String sessionDescription;

    public SessionDTO(Session dto) {
        id = dto.getId();
        sessionDescription = dto.getSessionDescription();
    }
}
