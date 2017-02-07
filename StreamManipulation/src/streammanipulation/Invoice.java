/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streammanipulation;

import java.util.Comparator;

/**
 *
 * @author vladshostak
 */
public class Invoice 
{
   private final String partNumber; 
   private final String partDescription;
   private int quantity;
   private double pricePerItem;

   // constructor
   public Invoice(String partNumber, String partDescription, int quantity,
      double pricePerItem)
   {
      if (quantity < 0) // validate quantity
         throw new IllegalArgumentException("Quantity must be >= 0");

      if (pricePerItem < 0.0) // validate pricePerItem
         throw new IllegalArgumentException(
            "Price per item must be >= 0");

      this.quantity = quantity;
      this.partNumber = partNumber;
      this.partDescription = partDescription;
      this.pricePerItem = pricePerItem;
   } // end constructor

    

   // START get two variables
   public String getDescriptionWithQuantity() {
    return String.format("%-20s %10s", partDescription, quantity);
   }
   public static Comparator<Invoice> quantityComparator = Comparator.comparing(Invoice::getQuantity);
   
   public String getDescriptionWithInvoice() {
    return String.format("%-20s %10.2f", partDescription, this.getPaymentAmount());
   }
   public static Comparator<Invoice> invoiceComparator = Comparator.comparing(Invoice::getPaymentAmount);
   // END get two variables
   
   
   // return String representation of Invoice object
   @Override
   public String toString()
   {
      return String.format("\n" + "%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f", 
         "invoice", "part number", getPartNumber(), getPartDescription(), 
         "quantity", getQuantity(), "price per item", getPricePerItem());
   }
   
   
   // get part number
   public String getPartNumber()
   {
      return partNumber;
   } 

   // get description
   public String getPartDescription()
   {
      return partDescription;
   } 

   // set quantity
   public void setQuantity(int quantity)
   {
      if (quantity < 0) // validate quantity
         throw new IllegalArgumentException("Quantity must be >= 0");

      this.quantity = quantity;
   } 

   // get quantity
   public int getQuantity()
   {
      return quantity;
   }

   // set price per item
   public void setPricePerItem(double pricePerItem)
   {
      if (pricePerItem < 0.0) // validate pricePerItem
         throw new IllegalArgumentException(
            "Price per item must be >= 0");

      this.pricePerItem = pricePerItem;
   } 

   // get price per item
   public double getPricePerItem()
   {
      return pricePerItem;
   } 

   // invoice ammount                                                              
   public double getPaymentAmount()                                    
   {                                                                   
      return getQuantity() * getPricePerItem(); // calculate total cost
   } 
} // end class Invoice