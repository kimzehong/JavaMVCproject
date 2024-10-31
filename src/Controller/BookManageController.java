package Controller;
import Dto.BookDTO;
import View.BookManageView;

import java.util.ArrayList;
import java.util.List;

public class BookManageController {
    private List<BookDTO> books;

    public BookManageController() {
        books = new ArrayList<>();
    }


    public void addBook(BookDTO book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다.: " + book);
    }


    public boolean deleteBook(String isbn) {
        for (BookDTO book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println("도서가 삭제되었습니다.: " + book);
                return true;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
        return false;
    }


    public boolean updateBook(String isbn, BookDTO updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.set(i, updatedBook);
                System.out.println("Book updated: " + updatedBook);
                return true;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
        return false;
    }


    public BookDTO findBookByIsbn(String isbn) {
        for (BookDTO book : books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("Book found: " + book);
                return book;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
        return null;
    }


    public List<BookDTO> getAllBooks() {
        return books;
    }

}

