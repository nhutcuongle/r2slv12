package exercise_2;
public class Library {

    void displayBookInfo(Book book) {
        System.out.println("Title: " + book.title);
        System.out.println("Author: " + book.author);
        System.out.println("Publication Year: " + book.publicationYear);
    }

    public static void main(String[] args) {
        Book book = new Book("1984", "George Orwell", 1949);

        Library library = new Library();
        library.displayBookInfo(book);
    }
}