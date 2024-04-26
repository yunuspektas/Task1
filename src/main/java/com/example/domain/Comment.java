package com.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "t_comment")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; // UUID

    @Column(length = 50)
    private String author;

    private String body;


    private LocalDateTime time = LocalDateTime.now();

//    @PrePersist
//    public void onPrePersist(){
//        this.time = LocalDateTime.now();
//    }

}
