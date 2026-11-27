package nonuser;

import java.io.Serializable;

public class PurchaseOrder implements Serializable {
    private final String poId;
    private int officerId;
    private int supplierId;
    private String bookTitle;
    private int quantity;
    private String status;
    private double quotedPrice;
    private String trackingNumber;

    public PurchaseOrder(String poId, int officerId, int supplierId, String bookTitle, int quantity, String status, double quotedPrice, String trackingNumber) {
        this.poId = poId;
        this.officerId = officerId;
        this.supplierId = supplierId;
        this.bookTitle = bookTitle;
        this.quantity = quantity;
        this.status = status;
        this.quotedPrice = quotedPrice;
        this.trackingNumber = trackingNumber;
    }

    public String getPoId() {
        return poId;
    }

    public int getOfficerId() {
        return officerId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public double getQuotedPrice() {
        return quotedPrice;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void attachQuotation(double price){
        this.quotedPrice= price;
    }
    public void markDispatched(String trackNo){
        this.trackingNumber=trackNo;
        this.status ="DISPATCHED";
    }
}
