package uz.elmurodov.services.book;

import ognl.ASTThisVarRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.dto.book.BookCreateDto;
import uz.elmurodov.dto.file.ResourceDto;
import uz.elmurodov.exceptions.NotFoundException;
import uz.elmurodov.mappers.BookMapper;
import uz.elmurodov.models.Book;
import uz.elmurodov.response.ResponseBody;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.file.FileStorageService;

import java.io.IOException;
import java.util.*;


@Service("fakeBookService")
public class FakeBookService implements BookService {

    private final BookMapper mapper;
    private final FileStorageService fileStorageService;

    @Autowired
    public FakeBookService(BookMapper mapper, FileStorageService fileStorageService) {
        this.mapper = mapper;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public ResponseEntity<Book> get(String id) {
        Optional<Book> optionalBook = BOOK_LIST.stream().filter(book -> book.getId().toString().equals(id)).findFirst();
        if (optionalBook.isEmpty())
            throw new NotFoundException(String.format("Book with id %s not found", id), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new ResponseBody<>(optionalBook.get()));
    }

    @Override
    public ResponseEntity<List<Book>> getAll() {
        return new ResponseEntity<>(new ResponseBody<>(BOOK_LIST));
    }

    @Override
    public ResponseEntity<String> create(BookCreateDto dto, MultipartFile file, MultipartFile img) throws IOException {
        Book book = mapper.toEntity(dto);
        ResponseEntity<String> response = new ResponseEntity<>(new ResponseBody<>(""));
        if (!bookFileType.contains(StringUtils.getFilenameExtension(file.getOriginalFilename()))
        ) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            return response;
        }
        if (!imgFileType.contains(StringUtils.getFilenameExtension(img.getOriginalFilename()))) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            return response;
        }
        ResourceDto resourceDto = fileStorageService.store(file);
        book.setResourceDto(resourceDto);
        book.setName(resourceDto.getOriginalName());
        String imgPath = fileStorageService.storeImg(img);
        book.setImgPath(imgPath);
        BOOK_LIST.add(book);
        response.getBody().setBody(book.getId());
        return response;
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
