package com.bibliotheque.model;

import java.time.LocalDate;

public class Loan {

    private final Book book;
    private final Member member;
    private final LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.loanDate = LocalDate.now();
    }

    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public boolean isReturned() { return returnDate != null; }

    public void returnBook() {
        returnDate = LocalDate.now();
    }
}
