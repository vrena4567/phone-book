import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBookManager {
    private Map<String, Contact> phoneBook;
    private Scanner scanner;

    public PhoneBookManager() {
        phoneBook = new HashMap<>();
        scanner = new Scanner(System.in);
    }


    public void run() {
        boolean running = true;
        ciklus:                                                 // ez egy label, használhatnánk a kilépéshez a ciklusból is (case 4 : break ciklus; )
        while (running) {
            printMenu(); // TODO valósítsd meg a printMenu() metódust!
            int choice = scanner.nextInt(); // TODO olvasd be a felhasználótól, mit szeretne csinálni!
            scanner.nextLine(); // vajon miért kell ez a sor?                                         >>> hogy beolvassa az entert is, stb.-t, a nextInt után szeretünk ilyen nextLine-t írni
            // TODO a megadott szám alapján hívd meg a megfelelő metódust vagy lépj ki!
            switch (choice) {
                case 0 : listContacts();
                case 1 : addContact();
                case 2 : searchContact();
                case 3 : removeContact();
                case 4 : running = false;
                default : System.out.println("héj");
            }
        }
        scanner.close();                                                // megvalósítja a closable interface-t
    }

    private void printMenu() {
        // TODO Írd ki az alábbi menüsort:
        //  0. List contacts
        //  1. Add contact
        //  2. Search contact
        //  3. Remove contact
        //  4. Exit
        System.out.println("0. List contacts\n" +
                "1. Add contact\n" +
                "2. Search contact\n" +
                "3. Remove contact\n" +
                "4. Exit");
    }

    private void listContacts() {
        // TODO Szépen formázva írd ki a telefonkönyv összes bejegyzését!
        for (Map.Entry<String, Contact> actual : phoneBook.entrySet()) {
//          System.out.println(actual.getKey() + " " + actual.getValue().getPhoneNumber());      << így is lehetne, de ha beviszünk a Contact class-ba egy toString metódust, úgy szebb lesz
            System.out.println(actual.getValue());
        }

    }

    private void addContact() {
        // TODO olvasd be egy változóba a kontakt nevét
        // TODO olvasd be egy változóba a kontakt telefonszámát
        // TODO példányosíts ezekből az adatokból egy Contact-ot
        // TODO tedd bele ezeket az infókat a mapbe:
        //      mi lesz a kulcs és mi az érték?
        System.out.println("Adja meg az új kontakt nevét:");
        String contactName = scanner.nextLine();
        System.out.println("Adja meg az új kontakt telefonszámát");
        String contactNumber = scanner.nextLine();
        Contact newContact = new Contact(contactName,contactNumber);
        phoneBook.put(contactName, newContact);
    }

    private void searchContact() {
        // TODO valósítsd meg a név alapján való keresést
        //  ha nem találod meg az adott kontaktot, jelezd
        //  azt is a felhasználónak!
        System.out.println("Adja meg a keresett kontakt nevét:");
        String name = scanner.nextLine();
        if(phoneBook.containsKey(name)) {
            System.out.println(phoneBook.get(name));
        } else {
            System.out.println("Nincs ilyen kontakt.");
        }

    }

    private void removeContact() {
        // TODO valósítsd meg a név alapján való törlést
        //  ha nem találod meg az adott kontaktot, jelezd
        //  azt is a felhasználónak!
        System.out.println("Melyik kontaktok szeretné törölni?");
        String name = scanner.nextLine();
            if (phoneBook.containsKey(name)) {
                phoneBook.remove(name);
            } else {
                System.out.println("Nincs ilyen kontakt a telefonkönyvben.");
            }

    }

}
