
package streammanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vladshostak
 */
public class StreamManipulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Invoice> mList= new ArrayList<>();
        
        mList.add(new Invoice("83", "Electric sander", 7, 57.98));
        mList.add(new Invoice("24", "Power saw", 18, 99.99));
        mList.add(new Invoice("7", "Sledge hammer", 11, 21.50));
        mList.add(new Invoice("77", "Hammer", 76, 11.99));
        mList.add(new Invoice("39", "Lawn mower", 3, 79.50));
        mList.add(new Invoice("68", "Screwdriver", 106, 6.99));
        mList.add(new Invoice("56", "Jig saw", 21, 11.00));
        mList.add(new Invoice("3", "Wrench", 34, 7.50));
        
        
        // ============================================
        // sort by part description
        System.out.println("By Part Description:");
       
        mList
        .stream()    
        .sorted((p1, p2) -> p1.getPartDescription().compareTo(p2.getPartDescription()) ) // natural string comparison
        .forEach(part -> System.out.println(part)); // prints using toString

        
        // ============================================
        //  sort by price
        System.out.println();
        System.out.println("By Price:");

        mList
        .stream()
        .sorted((p1, p2) -> Double.compare(p1.getPricePerItem(), p2.getPricePerItem()) ) // natural double comparison
        .forEach(part -> System.out.println(part)); // prints using toString


        // ============================================
        // sort by quantity.  Map part descr and quantity
        System.out.println();
        System.out.println("By Quantity:");
        System.out.println();

         mList
        .stream()
        .sorted(Invoice.quantityComparator)
        .map(p -> p.getDescriptionWithQuantity())
        .forEach(System.out::println);


        // ============================================
        // sort by invoice value.  Map part descr and value of invoice
        System.out.println();
        System.out.println("By Invoice Value:");
        System.out.println();

         mList
        .stream()
        .sorted(Invoice.invoiceComparator)
        .map(p -> p.getDescriptionWithInvoice())
        .forEach(System.out::println);
         
         
         // ============================================
        // sort by invoice value.  Map part descr and value of invoice in
        // range of $200 to $300 inclusive
        System.out.println();
        System.out.println("By Invoice Value (range 200-300):");
        System.out.println();

         mList
        .stream()
        .filter(p -> p.getPaymentAmount() >= 200 && p.getPaymentAmount() <= 300)
        .sorted(Invoice.invoiceComparator)
        .map(p -> p.getDescriptionWithInvoice())
        .forEach(System.out::println);
    
    
    }
    
}

