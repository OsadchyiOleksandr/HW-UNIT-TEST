import hillel.hw.Book;
import hillel.hw.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book("Title1", "Author1");
        book2 = new Book("Title2", "Author2");
    }

    @Test
    void givenBookAddedWhenAddBookThenBookCountIncreased() {
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book1));
    }

    @Test
    void givenNullBookWhenAddBookThenThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
    }

    @Test
    void givenBookInLibraryWhenRemoveBookWhenBookRemoved() {
        library.addBook(book1);
        assertTrue(library.removeBook(book1));
        assertEquals(0, library.getBookCount());
    }

    @Test
    void givenNoBookInLibraryWhenRemoveBookThenReturnFalse() {
        assertFalse(library.removeBook(book1));
    }

    @Test
    void givenNullBookWhenRemoveBookThenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> library.removeBook(null));
    }

    @Test
    void givenBooksInLibraryWhenGetBooksThenBooksReturned() {
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.getBookCount());
        assertTrue(library.getBooks().contains(book1));
        assertTrue(library.getBooks().contains(book2));
    }

    @Test
    void givenBooksInLibraryWhenGetBookCountThenCorrectCountReturned() {
        assertEquals(0, library.getBookCount());
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
        library.addBook(book2);
        assertEquals(2, library.getBookCount());
    }
}

