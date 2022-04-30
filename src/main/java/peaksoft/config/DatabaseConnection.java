package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import peaksoft.models.Book;
import peaksoft.models.Vendor;

import java.util.Properties;

public class DatabaseConnection {

    public static EntityManagerFactory createEntityManagerFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL,"jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.HBM2DDL_AUTO,"update");
        properties.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL,"true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Vendor.class);

        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
