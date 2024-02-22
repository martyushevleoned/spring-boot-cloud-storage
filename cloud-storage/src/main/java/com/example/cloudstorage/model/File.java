package com.example.cloudstorage.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "files")
@NoArgsConstructor
public class File {

    public File(String fileName, String source) {
        this.fileName = fileName;
        this.source = source;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text")
    private String fileName;

    @Column(columnDefinition = "text")
    private String source;

    public FileDto toFileDto(){
        return new FileDto(id, fileName);
    }
}
