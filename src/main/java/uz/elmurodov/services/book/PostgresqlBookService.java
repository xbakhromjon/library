package uz.elmurodov.services.book;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.dto.book.BookCreateDto;
import uz.elmurodov.models.Book;

import java.util.List;


@Service
public class PostgresqlBookService implements BookService {
    @Override
    public Book get(String id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public String create(BookCreateDto dto, MultipartFile file) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public boolean update(Object o) {
        return false;
    }
}
