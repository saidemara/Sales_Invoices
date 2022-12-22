package Model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    public static void main(String[] s) {
    }
    private String invoiceNum;
    private String invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> InvoiceLines;

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


}
