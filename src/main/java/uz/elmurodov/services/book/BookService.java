package uz.elmurodov.services.book;

import com.google.common.collect.Lists;
import org.apache.commons.io.input.ReaderInputStream;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.dto.book.BookCreateDto;
import uz.elmurodov.models.Book;
import uz.elmurodov.response.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface BookService {
    ArrayList<String> bookFileType = new ArrayList<>(Arrays.asList("pdf", "docs"));
    ArrayList<String> imgFileType = new ArrayList<>(Arrays.asList("jpeg", "png", "jpg"));
    List<Book> BOOK_LIST = Lists.newArrayList();

    ResponseEntity<Book> get(String id);

    ResponseEntity<List<Book>> getAll();

    ResponseEntity<String> create(BookCreateDto dto, MultipartFile file, MultipartFile img) throws IOException;

    ResponseEntity<Void> delete(String id);

    ResponseEntity<Boolean> update(Object o);

}
