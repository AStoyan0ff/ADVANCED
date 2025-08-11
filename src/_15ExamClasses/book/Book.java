package _15ExamClasses.book;
import java.util.*;

public class Book implements Iterable<String> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {

        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(String... authors) {

        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        }
        else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public Iterator<String> iterator() {
        return authors.iterator();
    }

    public static class TitleComparator implements Comparator<Book> {

        @Override
        public int compare(Book a, Book b) {
            return a.getTitle().compareTo(b.getTitle());
        }
    }

    public static class YearComparator implements Comparator<Book> {

        @Override
        public int compare(Book a, Book b) {
            return Integer.compare(a.getYear(), b.getYear());
        }
    }

    public static class AuthorCountComparator implements Comparator<Book> {

        @Override
        public int compare(Book a, Book b) {
            return Integer.compare(a.getAuthors().size(), b.getAuthors().size());
        }
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append(this.title).append("\", ").append(this.year);

        if (!authors.isEmpty()) {

            for (String author : authors) {
                result.append(", \"").append(author).append("\"");
            }
        }
        return result.toString();
    }
}