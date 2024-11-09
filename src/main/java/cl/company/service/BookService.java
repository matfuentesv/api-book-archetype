package cl.company.service;



import cl.company.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book findBook(Long id);
    Book createBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long id);

}
