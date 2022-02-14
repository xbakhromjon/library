package uz.elmurodov.mappers;

import org.springframework.stereotype.Component;
import uz.elmurodov.dto.book.BookCreateDto;
import uz.elmurodov.models.Book;

import java.util.UUID;

@Component
public class BookMapper {

    public Book toEntity(BookCreateDto dto) {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setAuthor(dto.getAuthor());
        book.setPageCount(dto.getPageCount());
        book.setPublisher(dto.getPublisher());
        book.setYear(dto.getYear());
        book.setLanguage(dto.getLanguage());
        book.setSummary(dto.getSummary());
        return book;
    }
}
