package IteratorPattern.example1;

import java.util.List;

public class BookIterator implements Iterator<Book>{
    List<Book> books;
    int position = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Book next() {
        return books.get(position++);
    }
}
