package utility;

import nonuser.*;
import user.LibraryMember;
import java.io.File;
import java.lang.reflect.Member;
import java.time.LocalDate;

public class DummyDataGenerator {

    public static void loadDummyData() {
        createDummyBooks();
        createDummyMembers();
        createDummyReservations();
        createDummyTransactions();
        createDummyPurchaseOrders();
        createDummyInvoices();
    }

    // 1. Sample Books for Librarian (Goals 1-6)
    private static void createDummyBooks() {
        if (!new File("Books.bin").exists()) {
            BinaryFileHandler.appendObject("Books.bin",
                    new Book("9780134685991", "Effective Java", "Joshua Bloch", "Programming", 5, 1200.0));
            BinaryFileHandler.appendObject("Books.bin",
                    new Book("9780132350884", "Clean Code", "Robert C. Martin", "Software Engineering", 3, 950.0));
            BinaryFileHandler.appendObject("Books.bin",
                    new Book("9780201633610", "Design Patterns", "Erich Gamma", "Computer Science", 2, 1100.0));
        }
    }

    private static void createDummyMembers() {
        if (!new File("Members.bin").exists()) {
            BinaryFileHandler.appendObject("Members.bin",
                    new LibraryMember(
                            1001,
                            1998123456789L,
                            "Rahim Uddin",
                            "01711111111",
                            "rahim@email.com",
                            "pass123",
                            "CARD-1001",
                            "Regular",
                            LocalDate.now().plusYears(1),
                            1
                    ));

            BinaryFileHandler.appendObject("Members.bin",
                    new LibraryMember(
                            1002,
                            1999987654321L,
                            "Karim Ahmed",
                            "01822222222",
                            "karim@email.com",
                            "pass456",
                            "CARD-1002",
                            "Student",
                            LocalDate.now().plusMonths(6),
                            1
                    ));

            BinaryFileHandler.appendObject("Members.bin",
                    new LibraryMember(
                            1003,
                            2000112233445L,
                            "Nusrat Jahan",
                            "01933333333",
                            "nusrat@email.com",
                            "pass789",
                            "CARD-1003",
                            "Premium",
                            LocalDate.now().plusYears(2),
                            0
                    ));
        }
    }



    private static void createDummyReservations() {
        if (!new File("Reservations.bin").exists()) {
            BinaryFileHandler.appendObject("Reservations.bin", new Reservation("RES-101", 1001, "9780134685991", LocalDate.now().minusDays(2), 1, "PENDING"));
            BinaryFileHandler.appendObject("Reservations.bin", new Reservation("RES-102", 1002, "9780132350884", LocalDate.now().minusDays(1), 1, "PENDING"));
            BinaryFileHandler.appendObject("Reservations.bin", new Reservation("RES-103", 1003, "9780134685991", LocalDate.now(), 2, "PENDING"));
        }
    }


    private static void createDummyTransactions() {
        if (!new File("Transactions.bin").exists()) {
            BinaryFileHandler.appendObject("Transactions.bin",
                    new Loantransaction("TX-101", 1001, "9780134685991", LocalDate.now().minusDays(5), LocalDate.now().plusDays(9), "ISSUED"));
            BinaryFileHandler.appendObject("Transactions.bin",
                    new Loantransaction("TX-102", 1002, "9780201633610", LocalDate.now().minusDays(20), LocalDate.now().minusDays(6), "OVERDUE"));
        }
    }

    private static void createDummyPurchaseOrders() {
        if (!new File("PurchaseOrders.bin").exists()) {
            BinaryFileHandler.appendObject("PurchaseOrders.bin", new PurchaseOrder("PO-101", 701, 201, "Effective Java", 10, "PENDING", 0.0, "N/A"));
            BinaryFileHandler.appendObject("PurchaseOrders.bin", new PurchaseOrder("PO-102", 701, 201, "Clean Code", 8, "ORDERED", 950.0, "N/A"));
            BinaryFileHandler.appendObject("PurchaseOrders.bin", new PurchaseOrder("PO-103", 701, 201, "Design Patterns", 5, "STOCK_ALLOCATED", 1100.0, "N/A"));
            BinaryFileHandler.appendObject("PurchaseOrders.bin", new PurchaseOrder("PO-104", 701, 201, "Effective Java", 2, "DAMAGED", 1200.0, "Sundarban_TRK998"));
        }
    }

    private static void createDummyInvoices() {
        if (!new File("Invoices.bin").exists()) {
            BinaryFileHandler.appendObject("Invoices.bin",
                    new Invoice("INV-101", "PO-102", 201, 7600.0, false));
            BinaryFileHandler.appendObject("Invoices.bin",
                    new Invoice("INV-102", "PO-103", 201, 5500.0, true));
        }
    }
}