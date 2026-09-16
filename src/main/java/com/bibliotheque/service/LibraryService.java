package com.bibliotheque.service;

import com.bibliotheque.model.Book;
import com.bibliotheque.model.Loan;
import com.bibliotheque.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibraryService {

    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String bookId) {
        return books.removeIf(book -> book.getId().equals(bookId));
    }

    public Optional<Book> findBookById(String bookId) {
        return books.stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst();
    }

    public List<Book> searchBooks(String query) {
        String normalizedQuery = query.toLowerCase();
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(normalizedQuery)
                        || book.getAuthor().toLowerCase().contains(normalizedQuery)
                        || book.getIsbn().toLowerCase().contains(normalizedQuery))
                .toList();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public boolean removeMember(String memberId) {
        return members.removeIf(member -> member.getId().equals(memberId));
    }

    public Optional<Member> findMemberById(String memberId) {
        return members.stream()
                .filter(member -> member.getId().equals(memberId))
                .findFirst();
    }

    public Loan borrowBook(String bookId, String memberId) {
        Book book = findBookById(bookId).orElseThrow(() -> new IllegalArgumentException("Livre introuvable"));
        Member member = findMemberById(memberId).orElseThrow(() -> new IllegalArgumentException("Membre introuvable"));
        if (!book.isAvailable()) {
            throw new IllegalStateException("Le livre n'est pas disponible");
        }
        book.setAvailable(false);
        Loan loan = new Loan(book, member);
        loans.add(loan);
        return loan;
    }

    public void returnBook(Loan loan) {
        loan.getBook().setAvailable(true);
        loan.returnBook();
    }

    public List<Book> getBooks() {
        return List.copyOf(books);
    }

    public List<Member> getMembers() {
        return List.copyOf(members);
    }

    public List<Loan> getLoans() {
        return List.copyOf(loans);
    }
}
