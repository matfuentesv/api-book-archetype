package cl.company.controller;


import cl.company.exception.ErrorResponse;
import cl.company.model.Book;
import cl.company.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@Log
public class BooksController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/findAllBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> findAllBook() {
        log.info("Se solicita la lista de todas las películas.");
         return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/findBook/{id}")
    public ResponseEntity<Object> findBook(@PathVariable Long id) {

        if (StringUtils.containsWhitespace(String.valueOf(id))|| id == null) {
            log.info("El id no se ingreso");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }
        return ResponseEntity.ok(bookService.findBook(id));
    }

    @PostMapping("/createBook")
    public ResponseEntity<Object> createBook(@Valid @RequestBody Book book,
                                             BindingResult bindingResult) throws MethodArgumentNotValidException {

        if (book == null) {
            log.info("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }

        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        return ResponseEntity.ok(bookService.createBook(book));
    }


    @PutMapping("/updateBook")
    public ResponseEntity<Object> updateBook(@Valid @RequestBody Book book,
                                             BindingResult bindingResult) throws MethodArgumentNotValidException {

        if (book == null) {
            log.info("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }

        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Object> deleteDoctor(@PathVariable Long id) {

        if (StringUtils.containsWhitespace(String.valueOf(id))|| id == null) {
            log.info("El id no se ingreso");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }


        Book book = bookService.findBook(id);

        if (book != null) {
            bookService.deleteBook(id);
            return ResponseEntity.ok(new ErrorResponse("Libro eliminado"));
        } else {
            log.info("Libro no encontrado con id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Libro no encontrado"));
        }
    }




}
