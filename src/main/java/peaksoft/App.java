package peaksoft;

import peaksoft.models.Book;
import peaksoft.models.Vendor;
import peaksoft.repositories.BookRepository;
import peaksoft.repositories.VendorRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {

        BookRepository bookRepository = new BookRepository();
        VendorRepository vendorRepository = new VendorRepository();

        //Book newBook = new Book("Ak keme", "Chyngyz Aitmatov", BigDecimal.valueOf(1500));

//        Vendor seit = new Vendor("Seit","seit@gmail.com");
//        Book book = new Book("Apple", "Steve Book", BigDecimal.valueOf(2500));
//        bookRepository.save(book);



//        seit.addBook(book);
//        book.setVendor(seit);
//        vendorRepository.save(seit);
//        Vendor vendor = vendorRepository.findById(1L);
//        Book book2 = bookRepository.findById(5L);
//        vendor.addBook(book2);
//        book2.setVendor(vendor);
//        vendorRepository.merge(vendor);
//        System.out.println(vendor);
       // bookRepository.deleteById(1L);



        bookRepository.deleteById(5L);



        bookRepository.close();
        vendorRepository.close();

    }
}
