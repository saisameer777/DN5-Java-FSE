package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService setterService = (BookService) context.getBean("bookServiceSetter");
        setterService.addBook("Clean Code");
        System.out.println("Setter injection: " + setterService.getBook(1));

        BookService constructorService = (BookService) context.getBean("bookServiceConstructor");
        constructorService.addBook("Design Patterns");
        System.out.println("Constructor injection: " + constructorService.getBook(2));

        ((ClassPathXmlApplicationContext) context).close();
    }
}
