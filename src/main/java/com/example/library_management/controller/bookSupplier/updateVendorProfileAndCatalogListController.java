package com.example.library_management.controller.bookSupplier;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import nonuser.Book;
import utility.AlertGenerator;
import utility.AppendableObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

public class updateVendorProfileAndCatalogListController
{
    @javafx.fxml.FXML
    private TableColumn<Book, String> titleCOL;
    @javafx.fxml.FXML
    private TextField wholeSalePriceTF;
    @javafx.fxml.FXML
    private TextField phoneNoTF;
    @javafx.fxml.FXML
    private TableColumn<Book,Double> wholeSalePriceCOL;
    @javafx.fxml.FXML
    private TableView<Book> vendorCatalogTable;
    @javafx.fxml.FXML
    private TextField titleTF;

    @javafx.fxml.FXML
    public void initialize() {
        titleCOL.setCellValueFactory(new PropertyValueFactory<>("title"));
        wholeSalePriceCOL.setCellValueFactory(new PropertyValueFactory<>("wholeSalePrice"));
        try{
            loadCatalogTable();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private ArrayList<Book> bookList= new ArrayList<>();
    public ArrayList<Book> readCatalog() throws IOException {

        File f = new File("SupplierCatalog.bin");
        if(!f.exists()){
            return bookList;
        }
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try{
            while(true){
                Book c =(Book) ois.readObject();
                bookList.add(c);
            }
        }catch (Exception e){
        }
        ois.close();
        return bookList;

    }
    private void loadCatalogTable() throws IOException {
        vendorCatalogTable.getItems().clear();
        ArrayList<Book> list = readCatalog();
        for(Book b:list){
            vendorCatalogTable.getItems().add(b);
        }
    }

    @javafx.fxml.FXML
    public void backToDashboardOA(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void addAndSaveCatalogOA(ActionEvent actionEvent) throws IOException {
        String title = titleTF.getText().trim();
        double price;
        try{
            price=Double.parseDouble(wholeSalePriceTF.getText().trim());
        } catch (NumberFormatException e){
            AlertGenerator.showAlert("Error","Price Must be Numeric");
            return;
        }
        ArrayList<Book> list = readCatalog();
        String code="SUP-"+(1001 + list.size());
        //Book item = new Book();
        File f = new File("SupplierCatalog.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;
        if(f.exists()){
            fos = new FileOutputStream(f,true);
            oos= new AppendableObjectOutputStream(fos);

        }else {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);

        }
       // oos.writeObject(item);
        oos.close();
        loadCatalogTable();
        AlertGenerator.showAlert("Success","Catalog item saved.");
    }
}