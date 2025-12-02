package com.icesi.Test.modelTest;

import com.icesi.model.ContactBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactBookTest {
    //Relationships (global variables)

    private ContactBook contactBook;

    public void setUp1(){
        contactBook = new ContactBook();
    }

    @Test
    public void addTest(){
        //Positive scenario

        //Arrange
        setUp1();
        boolean espectedResult = true;
        //Act
        boolean result = contactBook.add("Alvaro", "roa.alvarez7alvaro.jose@gmail.com","3128846926");
        //Assert
        assertEquals(contactBook.getContacts().size(), 1);
        assertEquals(contactBook.getContacts().get(0).getName(), "Alvaro");
        assertEquals(contactBook.getContacts().get(0).getPhone(), "3128846926");
        assertEquals(contactBook.getContacts().get(0).getEmail(),"roa.alvarez7alvaro.jose@gmail.com");
        assertEquals(espectedResult, result);

        //Negative scenario

        //Arrange
        setUp1();

        //Act
        result = contactBook.add("a","a","a");
        assertTrue(contactBook.getContacts().isEmpty());
        assertFalse(result);
    }

    @Test
    public void searchTest(){
        //Positive scenario

        //Arrange
        setUp1();
        contactBook.add("Alvaro","roa@gmail.com","3128846926");

        //Act
        String expectedName = "Alvaro";
        String expectedPhone = "3128846926";
        String expectedEmail = "roa.alvarez7alvaro";
        String name = contactBook.search("roa@gmail.com").getName();
        String phone = contactBook.search("roa@gmail.com").getPhone();
        String email = contactBook.search("roa@gmail.com").getEmail();

        //Assert
        assertEquals(expectedName, name);
        assertEquals(expectedPhone, phone);
        assertEquals(expectedEmail, email);

        //Negative scenario

        //Arrange
        setUp1();
        contactBook.add("Alvaro","roa@gmail.com","3128846926");

        //Act (cant without making an instance for contact)

        //Assert
        assertNull(contactBook.search("a"));
    }

    @Test
    public void removeTest(){
        //Positive

        //Arrange
        setUp1();
        contactBook.add("jeanfer","jeanfer@jeanfer", "3128846926");

        //Act
        String name = contactBook.remove("jeanfer@jeanfer").getName();

        //Assert
        assertEquals("jeanfer", name);
        assertTrue(contactBook.getContacts().isEmpty());

        //Negative

        //Arrange
        setUp1();
        contactBook.add("jeanfer","jeanfer@jeanfer", "3128846926");

        //Act
        contactBook.remove("jeanfer");

        //Assert
        assertFalse(contactBook.getContacts().isEmpty());
    }
}
