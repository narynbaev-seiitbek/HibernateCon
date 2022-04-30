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

//        Book book = new Book("Ak Keme", "Chyngyz Aitmatov", BigDecimal.valueOf(1000));
//        Book book2 = new Book("Jamilya","Chyngyz Aitmatov", BigDecimal.valueOf(1500));
//        Book book3 = new Book("Nasaat","Abdyshukur Nurmatov", BigDecimal.valueOf(2000));
//        Book book4 = new Book("Becoming","Mishel Obama", BigDecimal.valueOf(2500));
        Book book5 = new Book("Apple","Steve Jobs", BigDecimal.valueOf(2500));

        //Vendor vendor2 = new Vendor("Seitbek","seit@mail.ru");
        //Vendor vendor = vendorRepository.findById(4L);
        bookRepository.deleteById(6L);
       // vendorRepository.save(vendor2);

//        Vendor vendor1 = new Vendor("Azat","azat@mail.ru");
//        vendor1.setBooks(List.of(book3,book4));
//        vendorRepository.save(vendor1);
//
        //bookRepository.save(book);

        //bookRepository.findAll().forEach(System.out::println);

        bookRepository.close();
        vendorRepository.close();

    }
}
