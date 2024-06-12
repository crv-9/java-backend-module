package io.everyonecodes.w1springbeans.pathvariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class LibraryEndpoint {

    // injecting Library bean
    Library library;

    public LibraryEndpoint(Library library) {
        this.library = library;
    }

    // defining the specific path variable
    @GetMapping("/{bookName}")
    boolean isTheBookInStock(@PathVariable String bookName){
        return library.isBookInStock(bookName);
    }


}
