package com.example.requestprocessingservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "request", schema = "public")
@Getter
@Setter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text")
    private String text;
    @Column(name = "modified_date")
    private Long modifiedDate;
    @Column(name = "length")
    private Long length;
    @ManyToMany
    @JoinTable(
            name = "request_tag",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;
    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

}
