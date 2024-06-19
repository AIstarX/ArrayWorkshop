package se.lexicon;

public class NameRepository {
    private static String[] names = {"Erik Svensson", "Astrid Lindgren", "Greta Thunberg"};

    public static int getSize() {
        return names.length;
    }

    public static void setNames(String[] newNames) {
        names = newNames;
    }

    public static void clear() {
        names = new String[0];
    }

    public static String[] findAll() {
        return names.clone();
    }

    public static String find(String fullName) {
        for (String name : names) {
            if (name.equalsIgnoreCase(fullName)) {
                return name;
            }
        }
        return null;
    }

    public static boolean add(String fullName) {
        if (find(fullName) != null) {
            return false;
        }
        String[] newNames = new String[names.length + 1];
        System.arraycopy(names, 0, newNames, 0, names.length);
        newNames[names.length] = fullName;
        names = newNames;
        return true;
    }

    public static String[] findByFirstName(String firstName) {
        return findBy(firstName, true);
    }

    public static String[] findByLastName(String lastName) {
        return findBy(lastName, false);
    }

    private static String[] findBy(String searchTerm, boolean isFirstName) {
        String[] tempResult = {};
        int count = 0;
        for (String name : names) {
            if ((isFirstName && name.toLowerCase().startsWith(searchTerm.toLowerCase() + " ")) ||
                    (!isFirstName && name.toLowerCase().endsWith(" " + searchTerm.toLowerCase()))) {
                tempResult = addNameToArray(tempResult, name);
                count++;
            }
        }
        String[] result = new String[count];
        System.arraycopy(tempResult, 0, result, 0, count);
        return result;
    }

    public static boolean update(String original, String updatedName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(original)) {
                names[i] = updatedName;
                return true;
            }
        }
        return false;
    }

    public static boolean remove(String fullName) {
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(fullName)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        String[] newNames = new String[names.length - 1];
        System.arraycopy(names, 0, newNames, 0, index);
        System.arraycopy(names, index + 1, newNames, index, names.length - index - 1);
        names = newNames;
        return true;
    }

    private static String[] addNameToArray(String[] array, String name) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = name;
        return newArray;
    }
}
