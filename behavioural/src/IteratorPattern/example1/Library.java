package IteratorPattern.example1;

import java.util.ArrayList;
import java.util.List;

public class Library implements BookCollection {
    List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookIterator(bookList);
    }
}
