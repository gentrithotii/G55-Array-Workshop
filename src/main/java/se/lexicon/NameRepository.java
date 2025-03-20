package se.lexicon;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(String[] names) {
        NameRepository.names = names;
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        NameRepository.names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        String[] copyArray = new String[NameRepository.names.length];

        for (int i = 0; i < NameRepository.names.length; i++) {
            copyArray[i] = NameRepository.names[i];
        }

        return copyArray;
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {

        for (int i = 0; i < NameRepository.names.length; i++) {
            if (NameRepository.names[i].equalsIgnoreCase(fullName)) {
                return fullName;
            }
        }

        return "User not found";
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        String[] newArrayNames = new String[names.length + 1];

        for (int i = 0; i < NameRepository.names.length; i++) {
            if (find(fullName).equalsIgnoreCase(fullName)) {
                return false;
            }
            newArrayNames[i] = names[i];
        }
        newArrayNames[newArrayNames.length - 1] = fullName;

        setNames(newArrayNames);

        return true;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {
        int foundName = 0;
        for (int i = 0; i < NameRepository.names.length; i++) {
            if (names[i].contains(firstName)) {
                foundName++;
            }
        }

        String[] matchingNamesArray = new String[foundName];

        for (int i = 0, j = 0; i < NameRepository.names.length; i++) {
            if (names[i].contains(firstName)) {
                matchingNamesArray[j] = names[i];
                j++;
            }
        }

        return matchingNamesArray;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {
        int foundName = 0;
        for (int i = 0; i < NameRepository.names.length; i++) {
            if (names[i].contains(lastName)) {
                foundName++;
            }
        }

        String[] matchingLastNamesArray = new String[foundName];

        for (int i = 0, j = 0; i < NameRepository.names.length; i++) {
            if (names[i].contains(lastName)) {
                matchingLastNamesArray[j] = names[i];
                j++;
            }
        }

        return matchingLastNamesArray;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {
        for (int i = 0; i < NameRepository.names.length; i++) {

            if (names[i].equalsIgnoreCase(updatedName)) {
                return false;
            } else if (names[i].equalsIgnoreCase(original)) {
                names[i] = updatedName;
                setNames(names);
                return true;
            }

        }
        return false;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {
        String[] arrayOfNumbs = new String[NameRepository.names.length - 1];

        for (int i = 0, j = 0; i < names.length; i++) {
            if (!find(fullName).equals(fullName)) {
                return false;
            } else if (names[i].contains(fullName)) {

            } else {
                arrayOfNumbs[j] = names[i];
                j++;
            }
        }

        setNames(arrayOfNumbs);
        return true;
    }


}