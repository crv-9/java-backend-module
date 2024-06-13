package io.everyonecodes.w1springbeans.pathvariable;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class Library {
    private final Set<String> books = Set.of(
            "Moby Dick", "Don Quixote", "The Great Gatsby", "Hamlet"
    );

    public boolean isBookInStock(String bookName) {
        return books.contains(bookName);
    }
}
