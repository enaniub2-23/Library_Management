package nonuser;

import java.io.Serializable;

public class Fine implements Serializable {

        private final String fineId;
        private int memberId;
        private String transactionId;
        private double amount;
        private boolean isPaid;

    public Fine(String fineId, int memberId, String transactionId, double amount, boolean isPaid) {
        this.fineId = fineId;
        this.memberId = memberId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public String getFineId() {
        return fineId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
    public void markAsPaid() {
        this.isPaid = true;
    }
}
