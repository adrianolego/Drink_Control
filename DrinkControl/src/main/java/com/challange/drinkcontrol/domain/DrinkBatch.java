package com.challange.drinkcontrol.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class DrinkBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dateTime;
    private Integer amount;
    private String responsiblePerson;

    @OneToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @OneToOne
    @JoinColumn(name = "drinktype_id")
    private DrinkType drinkType;

    public DrinkBatch(Integer id, LocalDateTime dateTime, Integer amount, Session session, DrinkType drinkType) {
        this.id = id;
        this.dateTime = dateTime;
        this.amount = amount;
        this.session = (session == null ? null : session);
        this.drinkType = (drinkType == null ? null : drinkType);
    }
}
