package com.github.fbenz.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    public List<Book> listBooks() {
        Book book1 = new Book("1");
        book1.setTitle("Fall of Giants");
        book1.setPages(842);
        return Collections.singletonList(book1);
    }

    @POST
    public void addItem(Book book) {
    }
}
