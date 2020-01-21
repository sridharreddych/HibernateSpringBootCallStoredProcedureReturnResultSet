package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nNamed stored procedure ...");
            bookstoreService.fetchAnthologyAuthorsViaNamedStoredProcedure();

            System.out.println("\n---------------------------------------------------------");

            System.out.println("\nStored procedure ...");
            bookstoreService.fetchAnthologyAuthorsViaStoredProcedure();

            System.out.println("\n---------------------------------------------------------");

            System.out.println("\nStored procedure and DTO ...");
            bookstoreService.fetchAnthologyDtoAuthorsViaStoredProcedure();

            System.out.println("\n---------------------------------------------------------");

            System.out.println("\nStored procedure and manually mapping DTO ...");
            bookstoreService.fetchAnthologyManualMappingDtoAuthorsViaStoredProcedure();
        };
    }
}

/*
 * Calling Stored Procedure That Returns A Result Set (Entity And DTO)

Description: This application is an example of calling a MySQL stored procedure that returns a result set. The application fetches entities (e.g., List<Author>) and DTO (e.g., List<AuthorDto>).

Key points:

rely on EntiyManager since Spring Data @Procedure will not work
 */

