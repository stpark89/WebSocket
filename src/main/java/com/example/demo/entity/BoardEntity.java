package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(length = 100)
    private String title;

    @Column(length = 4000)
    private String contents;


}
