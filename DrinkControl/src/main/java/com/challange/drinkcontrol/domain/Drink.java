package com.challange.drinkcontrol.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dateTime;
    private Integer amount;

    @OneToOne
    @JoinColumn(name = "session_id")
    private Session session;

    public Drink(Integer id, LocalDateTime dateTime, Integer amount, Session session) {
//    public Drink(Integer id, LocalDateTime dateTime, Integer amount) {
        this.id = id;
        this.dateTime = dateTime;
        this.amount = amount;
        this.session = (session == null ? null : session);
    }
}
