package com.example.requestprocessingservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "folder", schema = "public")
@Getter
@Setter
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "folder_name")
    private String folderName;
    @OneToMany(mappedBy = "folder")
    private List<Request> requests;
}
