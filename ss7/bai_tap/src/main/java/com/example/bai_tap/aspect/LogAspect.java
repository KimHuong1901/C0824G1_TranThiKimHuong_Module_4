package com.example.bai_tap.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Before("execution(* com.example.bai_tap.service.BookService.borrowBook(..))")
    public void logBeforeBorrow() {
        System.out.println("Log: A user is attempting to borrow a book.");
    }

    @AfterReturning("execution(* com.example.bai_tap.service.BookService.borrowBook(..))")
    public void logAfterBorrow() {
        System.out.println("Log: Book borrowed successfully and quantity updated.");
    }

    @AfterThrowing(value = "execution(* com.example.bai_tap.service.BookService.borrowBook(..))", throwing = "exception")
    public void logErrorDuringBorrow(Exception exception) {
        System.out.println("Log: Error while borrowing book: " + exception.getMessage());
    }

    @Before("execution(* com.example.bai_tap.service.BookService.returnBook(..))")
    public void logBeforeReturn() {
        System.out.println("Log: A user is attempting to return a book.");
    }

    @AfterReturning("execution(* com.example.bai_tap.service.BookService.returnBook(..))")
    public void logAfterReturn() {
        System.out.println("Log: Book returned successfully and quantity updated.");
    }

    @AfterThrowing(value = "execution(* com.example.bai_tap.service.BookService.returnBook(..))", throwing = "exception")
    public void logErrorDuringReturn(Exception exception) {
        System.out.println("Log: Error while returning book: " + exception.getMessage());
    }
}
