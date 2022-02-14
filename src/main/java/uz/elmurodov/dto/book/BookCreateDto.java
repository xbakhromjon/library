package uz.elmurodov.dto.book;

import lombok.*;
import uz.elmurodov.dto.file.ResourceDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookCreateDto {
    private String author;
    private Integer pageCount;
    private String description;
    private Long year;
    private String publisher;
    private String summary;
    private String language;
}
