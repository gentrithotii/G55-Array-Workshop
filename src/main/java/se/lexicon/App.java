package se.lexicon;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println(NameRepository.getSize());
        NameRepository.clear();
        System.out.println(NameRepository.getSize());

        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});

        String[] copyNamesArray = NameRepository.findAll();

        System.out.println(" The copy Array: " + Arrays.toString(copyNamesArray));


        String result = NameRepository.find("Mehrdad Javan");
        System.out.println(result);

        NameRepository.add("Gentrit Hoti");
        NameRepository.add("Gentrit Luan");
        NameRepository.add("Gentrit Emilia");
        NameRepository.add("Gentrit Millian");
        NameRepository.add("Gentrit Luna");
        NameRepository.add("Genc Hoti");
        NameRepository.add("Gonxhe Hoti");
        NameRepository.add("Gelinda Hoti");

        System.out.println("This needs to be false: " + NameRepository.add("Genc Hoti"));




//        System.out.println(NameRepository.getSize());
//
//        String result1 = NameRepository.find("Gentrit Hoti");
//        System.out.println(result1);
//
//        String[] findByFirstNameArray = NameRepository.findByFirstName("Gentrit");
//        System.out.println("Find by First Name:  " + Arrays.toString(findByFirstNameArray));
//
//        String[] findByLastNameArray = NameRepository.findByLastName("Hoti");
//        System.out.println("Find by Last Name: " + Arrays.toString(findByLastNameArray));
//
//
//        System.out.println(NameRepository.update("Gentrit vf", "Millian Hoti"));
//
//        System.out.println(NameRepository.remove("Gentrit Hoti"));


        String[] copyNamesArrayTwo = NameRepository.findAll();
        System.out.println(Arrays.toString(copyNamesArrayTwo));


        // call more methods as needed
    }
}
