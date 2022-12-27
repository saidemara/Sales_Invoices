package Model;

public class InvoiceLine {


    private String InvoiceNumber;
    private String itemName;
    private String itemPrice;
    private String count;

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        InvoiceNumber = invoiceNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "The Invoice LineID is : " + getInvoiceNumber() + "Item Name is: "
                + getItemName() + " Item Price ia :" + getItemPrice() + " Count is " + getCount();
    }
}
