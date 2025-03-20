package se.lexicon;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests for the NameRepository class.
 */
public class NameRepositoryTest {

    @Test
    @DisplayName("get Array size ")
    public void getSizeTest() {
        //Arrange

        String[] names = new String[]{"Gentrit Hoti", "Genc Hoti", "Gelinda Hoti", "Gonxhe Hoti"};
        NameRepository.setNames(names);

        //Act

        int result = NameRepository.getSize();
        int expected = names.length;

        //Assert

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Set names to the List")
    public void setNamesTest() {
        //Arrange

        String[] result = new String[]{"Gentrit Hoti", "Genc Hoti", "Gelinda Hoti", "Gonxhe Hoti"};
        String[] expected = new String[]{"Gentrit Hoti", "Genc Hoti", "Gelinda Hoti", "Gonxhe Hoti"};
        //Act

        NameRepository.setNames(result);

        //Assert

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test if it clears the Array of names")
    public void clearArrayTest() {
        //Arrange

        String[] namesToSet = new String[]{"Gentrit Hoti", "Genc Hoti", "Gelinda Hoti", "Gonxhe Hoti"};
        String[] expected = new String[0];

        //Act

        NameRepository.setNames(namesToSet);
        NameRepository.clear();
        String[] result = NameRepository.findAll();

        //Assert

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test Copy Array to new Array")
    public void findAllTest() {
        //Arrange
        String[] expected = new String[]{"Gentrit Hoti", "Genc Hoti", "Gelinda Hoti", "Gonxhe Hoti"};
        //Act
        NameRepository.setNames(expected);
        String[] result = NameRepository.findAll();
        //Assert
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Find By FullName")
    public void findTest() {
        //Arrange
        String[] arraySet = new String[]{"Gentrit Hoti", "Genc Hoti", "Gelinda Hoti", "Gonxhe Hoti"};
        //Act
        NameRepository.setNames(arraySet);
        String result = NameRepository.find("Gentrit Hoti");
        String expected = "Gentrit Hoti";

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Adding ")
    public void addTest() {
        //Arrange

        String[] arraySet = new String[]{"Gentrit Hoti", "Genc Hoti", "Gelinda Hoti", "Gonxhe Hoti"};
        String[] expected = new String[]{"Gentrit Hoti", "Genc Hoti", "Gelinda Hoti", "Gonxhe Hoti", "Mehrdad Javan"};

        //Act
        NameRepository.setNames(arraySet);
        NameRepository.add("Mehrdad Javan");
        String[] result = NameRepository.findAll();

        //Assert
        Assertions.assertArrayEquals(expected, result);

    }

    @Test
    @DisplayName("Find All that have the same firstname")
    public void findByFirstNameTest() {
        //Arrange
        String[] arraySet = new String[]{"Gentrit Hoti", "Genc Hoti", "Gelinda Hoti", "Gonxhe Hoti", "Gentrit Gashi", "Gentrit Kelmendi", "Gentrit Kalludra"};
    }
}
