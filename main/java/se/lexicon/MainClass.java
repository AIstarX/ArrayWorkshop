package se.lexicon;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Initial size: " + NameRepository.getSize());

        String[] newNames = {"Carl Linnaeus", "August Strindberg"};
        NameRepository.setNames(newNames);
        System.out.println("Names after setNames: " + String.join(", ", NameRepository.findAll()));

        NameRepository.add("Selma Lagerlöf");
        System.out.println("Names after add: " + String.join(", ", NameRepository.findAll()));

        NameRepository.remove("August Strindberg");
        System.out.println("Names after remove: " + String.join(", ", NameRepository.findAll()));

        System.out.println("Find by first name 'Carl': " + String.join(", ", NameRepository.findByFirstName("Carl")));

        System.out.println("Find by last name 'Lagerlöf': " + String.join(", ", NameRepository.findByLastName("Lagerlöf")));

        NameRepository.update("Carl Linnaeus", "Carl von Linné");
        System.out.println("Names after update: " + String.join(", ", NameRepository.findAll()));

        NameRepository.clear();
        System.out.println("Size after clear: " + NameRepository.getSize());
    }
}
