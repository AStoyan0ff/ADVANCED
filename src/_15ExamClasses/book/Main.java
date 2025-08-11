package _15ExamClasses.book;
import java.util.*;

public class Main { // Skeleton
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();

        books.add(bookOne);
        books.add(bookThree);
        books.add(bookTwo);

        for (Book b : books) {
            System.out.println(b);
        }
    }
}
