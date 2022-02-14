package uz.elmurodov.dto.book;

import lombok.*;
import uz.elmurodov.dto.file.ResourceDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookCreateDto {
    private String name;
    private String author;
    private Integer pageCount;
    private String description;
}
