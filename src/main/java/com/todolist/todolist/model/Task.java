package com.todolist.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id")
    @SequenceGenerator(name = "sequence_id", sequenceName = "pes_seq")
    private Long id;

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    private Long finished;

}
