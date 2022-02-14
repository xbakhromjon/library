package uz.elmurodov.services.book;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.dto.book.BookCreateDto;
import uz.elmurodov.models.Book;
import uz.elmurodov.response.ResponseEntity;

import java.io.IOException;
import java.util.List;


@Service
public class PostgresqlBookService implements BookService {
    @Override
    public ResponseEntity<Book> get(String id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Book>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<String> create(BookCreateDto dto, MultipartFile file, MultipartFile img) throws IOException {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> update(Object o) {
        return null;
    }
}
