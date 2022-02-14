package uz.elmurodov.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.dto.file.ResourceDto;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class Book {
    private UUID id;
    private String name;
    private Integer pageCount;
    private String author;
    private ResourceDto resourceDto;
    private String description;
    private Long year;
    private String publisher;
    private String summary;
    private String language;
    private String extention;
    private double size;
    private String imgPath;

    public Book() {
        this.id = UUID.randomUUID();
    }

    public Book(UUID id, String name, String author, Integer pageCount) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getId() {
        return id.toString();
    }
}
