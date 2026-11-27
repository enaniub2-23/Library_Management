package nonuser;

import java.io.Serializable;

public class Invoice implements Serializable {
    private final String invoiceId;
    private String poId;
    private int supplierId;
    private double totalAmount;
    private boolean isSettled;

    public Invoice(String invoiceId, String poId, int supplierId, double totalAmount, boolean isSettled) {
        this.invoiceId = invoiceId;
        this.poId = poId;
        this.supplierId = supplierId;
        this.totalAmount = totalAmount;
        this.isSettled = isSettled;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getPoId() {
        return poId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isSettled() {
        return isSettled;
    }
    public void settleInvoice(){
        this.isSettled= true;
    }
    public String getStatus(){
        if(isSettled){
            return "PAID";
        }
        return "UNPAID";
    }
}
