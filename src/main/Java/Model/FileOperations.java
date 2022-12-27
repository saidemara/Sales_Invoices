package Model;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;



public class FileOperations {

    public static void main(String[] args) {
             FileOperations FileObj = new FileOperations();
       for (InvoiceHeader ListHeaders :FileObj.GetInvoiceHeader())
              {
                  for (InvoiceLine LineValue :FileObj.GetInvoiceLine())
                  {
                      System.out.println(ListHeaders.getInvoiceNum() +"{"
                              + ListHeaders.getInvoiceDate()+"__"+ ListHeaders.getCustomerName());
                    if(ListHeaders.getInvoiceNum()==LineValue.getInvoiceNumber())
                    {
                        System.out.println(LineValue.getItemName() +","
                                + LineValue.getItemPrice()+","+ LineValue.getCount());

                    }
                  }




        }


    }
    ArrayList<InvoiceHeader> invoiceList;
    ArrayList<InvoiceLine> invoiceLineList;

    public  ArrayList<InvoiceHeader>  GetInvoiceHeader()
    {
            try
            {
                invoiceList = new ArrayList<InvoiceHeader>();
                InvoiceHeader invoice = new InvoiceHeader();
                //creating a new file instance
                File file = new File("src/main/resources/InvoiceHeader.xlsx");
                FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file

//creating Workbook instance that refers to .xlsx file
                //creating a Sheet object to retrieve object
                //iterating over excel file

                //If it is xlsx file then create object of XSSFWorkbook class
                Workbook wb = new XSSFWorkbook(fis);
                Sheet sheet = wb.getSheetAt(0);
                int rowCount = sheet.getLastRowNum();

                //Create a loop over all the rows of excel file to read it

                for (int i = 0; i < rowCount+1; i++) {

                    Row row = sheet.getRow(i);

                    //Create a loop to print cell values in a row

                    for (int j = 0; j < row.getLastCellNum(); j++) {
                   invoice.setInvoiceNum(row.getCell(j).toString());
                   j++;
                   invoice.setInvoiceDate(row.getCell(j).toString());
                    j++;
                   invoice.setCustomerName(row.getCell(j).toString());
                        invoiceList.add(invoice);

                        //Print Excel data in console
//                        System.out.print(invoice.getInvoiceDate());
                    }
                    }

            } catch (FileNotFoundException e) {

            } catch (IOException e) {
            }
        return  invoiceList;

    }


    public  ArrayList<InvoiceLine>  GetInvoiceLine()
    {
        try
        {
            invoiceLineList = new ArrayList<InvoiceLine>();
            InvoiceLine invoiceLine = new InvoiceLine();
            //creating a new file instance
            File file = new File("src/main/resources/InvoiceLine.xlsx");
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file

//creating Workbook instance that refers to .xlsx file
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);
            int rowCount = sheet.getLastRowNum();

            //Create a loop over all the rows of excel file to read it

            for (int i = 0; i < rowCount+1; i++) {

                Row row = sheet.getRow(i);

                //Create a loop to print cell values in a row

                for (int j = 0; j < row.getLastCellNum(); j++) {
                    invoiceLine.setInvoiceNumber(row.getCell(j).toString());
                    j++;
                    invoiceLine.setItemName(row.getCell(j).toString());
                    j++;
                    invoiceLine.setItemPrice(row.getCell(j).toString());
                    j++;
                    invoiceLine.setCount(row.getCell(j).toString());

                    invoiceLineList.add(invoiceLine);

                    //Print Excel data in console
                        System.out.print(invoiceLine.getInvoiceNumber());
                }
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }
        return  invoiceLineList;

    }

}
