package nonuser;

import java.io.Serializable;

public class Book implements Serializable {
    private final String isbn;
    private String title;
    private String author;
    private String category;
    private String rackLocation;
    private int availableCopies;
    private double unitPrice;

    public Book(String isbn, String title, String author, String category, String rackLocation, int availableCopies, double unitPrice) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.rackLocation = rackLocation;
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

    public String getRackLocation() {
        return rackLocation;
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

    public void setRackLocation(String rackLocation) {
        this.rackLocation = rackLocation;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public boolean isAvailable(){
        return availableCopies>0;
    }
    public void updateStock(int quantityChange){
        this.availableCopies =this.availableCopies+quantityChange;
    }
}
