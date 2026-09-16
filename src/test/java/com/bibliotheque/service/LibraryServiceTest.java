package com.bibliotheque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bibliotheque.model.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LibraryServiceTest {

    @Test
    @DisplayName("un livre neuf est disponible")
    void livreNeufEstDisponible() {
        Book livre = new Book("1", "Le Petit Prince", "Saint-Exupery", "978-2070612758");
        assertTrue(livre.isAvailable());
    }

    @Test
    @DisplayName("un livre emprunte n est plus disponible")
    void livreEmprunteNEstPlusDisponible() {
        Book livre = new Book("2", "L Etranger", "Camus", "978-2070360024");
        livre.setAvailable(false);
        assertFalse(livre.isAvailable());
    }

    @Test
    @DisplayName("le titre saisi est bien celui restitue")
    void titreRestitue() {
        Book livre = new Book("3", "Germinal", "Zola", "978-2070413027");
        assertEquals("Germinal", livre.getTitle());
    }
}
