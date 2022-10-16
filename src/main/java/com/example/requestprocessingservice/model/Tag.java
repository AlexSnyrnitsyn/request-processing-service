package com.example.requestprocessingservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag", schema = "public")
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tag_name")
    private String tagName;
    @ManyToMany(mappedBy = "tags")
    private Set<Request> requests;
}
