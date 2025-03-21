package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests for the NameRepository class.
 */
public class NameRepositoryTest {

    @Test
    @DisplayName("Get Array size ")
    public void getSizeTest() {
        //Arrange
        String[] names = new String[]{"Gentrit Hoti", "Genc Hoti", "Gelinda Hoti", "Gonxhe Hoti"};
        NameRepository.setNames(names);
        int expected = names.length;

        //Act
        int result = NameRepository.getSize();

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Get size when array is empty")
    public void getSizeEmptyTest() {
        //Arrange
        NameRepository.setNames(new String[0]);
        int expected = 0;

        //Act
        int result = NameRepository.getSize();

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Set names to the List")
    public void setNamesTest() {
        //Arrange
        String[] expected = new String[]{"Gentrit Hoti", "Genc Hoti", "Gelinda Hoti", "Gonxhe Hoti"};

        //Act
        NameRepository.setNames(expected);
        String[] result = NameRepository.findAll();

        //Assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Clear array of names")
    public void clearArrayTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti"});
        String[] expected = new String[0];

        //Act
        NameRepository.clear();
        String[] result = NameRepository.findAll();

        //Assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Find By FullName")
    public void findTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti"});
        String expected = "Gentrit Hoti";

        //Act
        String result = NameRepository.find("Gentrit Hoti");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Find a name that does not exist")
    public void findNonExistingNameTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti"});
        String expected = "User not found";

        //Act
        String result = NameRepository.find("Unknown Name");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Find By First Name")
    public void findByFirstNameTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti", "Gentrit Jashari"});
        String[] expected = new String[]{"Gentrit Hoti", "Gentrit Jashari"};

        //Act
        String[] result = NameRepository.findByFirstName("Gentrit");

        //Assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Find By Last Name")
    public void findByLastNameTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti", "Gentrit Jashari"});
        String[] expected = new String[]{"Gentrit Hoti", "Genc Hoti"};

        //Act
        String[] result = NameRepository.findByLastName("Hoti");

        //Assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Find By First Name - No First Name Provided")
    public void findByFirstNameNoNameTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti", "Gentrit Jashari"});
        String[] expected = new String[]{};

        //Act
        String[] result = NameRepository.findByFirstName("");

        //Assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Find By First Name - Null First Name Provided")
    public void findByFirstNameNullNameTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti", "Gentrit Jashari"});
        String[] expected = new String[]{};

        //Act
        String[] result = NameRepository.findByFirstName(null);

        //Assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Find By Last Name - No Last Name Provided")
    public void findByLastNameNoLastNameTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti", "Gentrit Jashari"});
        String[] expected = new String[]{};

        //Act
        String[] result = NameRepository.findByLastName("");

        //Assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Find By Last Name - Null Last Name Provided")
    public void findByLastNameNullLastNameTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti", "Gentrit Jashari"});
        String[] expected = new String[]{};

        //Act
        String[] result = NameRepository.findByLastName(null);

        //Assert
        Assertions.assertArrayEquals(expected, result);
    }


    @Test
    @DisplayName("Add new name")
    public void addTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti"});
        boolean expected = true;

        //Act
        boolean result = NameRepository.add("Mehrdad Javan");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Add duplicate name")
    public void addDuplicateTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti"});
        boolean expected = false;

        //Act
        boolean result = NameRepository.add("Gentrit Hoti");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Update a name")
    public void updateTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti"});
        boolean expected = true;

        //Act
        boolean result = NameRepository.update("Gentrit Hoti", "Millian Hoti");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Update non-existing name")
    public void updateNonExistingTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti"});
        boolean expected = false;

        //Act
        boolean result = NameRepository.update("NonExistent Name", "New Name");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Remove a full name")
    public void removeTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti"});
        boolean expected = true;

        //Act
        boolean result = NameRepository.remove("Genc Hoti");

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Remove non-existing name")
    public void removeNonExistingTest() {
        //Arrange
        NameRepository.setNames(new String[]{"Gentrit Hoti", "Genc Hoti"});
        boolean expected = false;

        //Act
        boolean result = NameRepository.remove("Unknown Name");

        //Assert
        Assertions.assertEquals(expected, result);
    }
}
