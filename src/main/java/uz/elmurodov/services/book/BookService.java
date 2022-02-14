package uz.elmurodov.services.book;

import com.google.common.collect.Lists;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.dto.book.BookCreateDto;
import uz.elmurodov.models.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {

    List<Book> BOOK_LIST = Lists.newArrayList();

    Book get(String id);

    List<Book> getAll();

    String create(BookCreateDto dto, MultipartFile file) throws IOException;

    void delete(String id);

    boolean update(Object o);

}
