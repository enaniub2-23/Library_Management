package nonuser;

import java.io.Serializable;

public class Book implements Serializable {
    private final String isbn;
    private String title;
    private String author;
    private String category;
    private int availableCopies;
    private double unitPrice;

    public Book(String isbn, String title, String author, String category,
                 int availableCopies, double unitPrice) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
        this.unitPrice = unitPrice;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }




    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isAvailable() {
        return availableCopies > 0;
    }

    public void updateStock(int quantityChange) {
        this.availableCopies = this.availableCopies + quantityChange;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", availableCopies=" + availableCopies +
                ", unitPrice=" + unitPrice +
                '}';
    }
}