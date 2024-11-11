package seminars.fourth.book;

public class Main {
    public static void main(String[] args) {

        BookRepository bookRepository = new InMemoryBookRepository();


        BookService bookService = new BookService(bookRepository);


        String bookId = "1";
        Book book = bookService.findBookById(bookId);
        if (book != null) {
            System.out.println("Books with ID " + bookId + ": " + book.getTitle() + " Author: " + book.getAuthor());
        } else {
            System.out.println("Books with ID " + bookId + " no found.");
        }


        System.out.println("\nList all books:");
        for (Book b : bookService.findAllBooks()) {
            System.out.println("ID: " + b.getId() + ", Title: " + b.getTitle() + ", Author: " + b.getAuthor());
        }
    }
}
