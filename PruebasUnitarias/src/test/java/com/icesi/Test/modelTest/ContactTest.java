package com.icesi.Test.modelTest;

import com.icesi.model.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    //Relationships (global test class)

    private Contact contact;

    public void setUp1() {
        contact = new Contact("alvaro", "roa.alvarez7alvaro.jose@gmail.com", "3128846926");
    }

    @Test
    public void testConstructor() {
        // Arrange
        setUp1();
        // Act (none)

        // Assert
        assertEquals("alvaro", contact.getName());
        assertEquals("roa.alvarez7alvaro.jose@gmail.com", contact.getEmail());
        assertEquals("3128846926", contact.getPhone());
    }
}
