package user;

import nonuser.Invoice;

public class BookSupplier extends User {
    private String companyName;
    private String tradeLicense;

    public BookSupplier(int id, long nid, String name, String phoneNo, String email, String password, String companyName, String tradeLicense) {
        super(id, nid, name, phoneNo, email, password);
        this.companyName = companyName;
        this.tradeLicense = tradeLicense;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTradeLicense() {
        return tradeLicense;
    }

    public void setTradeLicense(String tradeLicense) {
        this.tradeLicense = tradeLicense;
    }
    public String getDashboardFXML(){
        return "BookSupplierDashboardView.fxml";
    }
    public void submitQuotation(String poId,double price){
        //
    }
    public void dispatchShipment(String poId,String trackNo){
        //
    }
    public Invoice submitInvoice(String poId,double amount){
        return new Invoice("INV-1001",poId,this.id,amount,false);
    }
}