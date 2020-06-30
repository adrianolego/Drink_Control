package com.challange.drinkcontrol.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class BatchDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dateTime;
    private Integer amount;

    @OneToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @OneToOne
    @JoinColumn(name = "drinktype_id")
    private DrinkType drinkType;

    public BatchDrink(Integer id, LocalDateTime dateTime, Integer amount, Session session, DrinkType drinkType) {
        this.id = id;
        this.dateTime = dateTime;
        this.amount = amount;
        this.session = (session == null ? null : session);
        this.drinkType = (drinkType == null ? null : drinkType);
    }
}
