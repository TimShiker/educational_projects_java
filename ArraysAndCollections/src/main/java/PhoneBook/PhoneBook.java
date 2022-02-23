package PhoneBook;

import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class PhoneBook {

    private static final String INFO_SAVED_CONTACT = "Contact saved!";

    private TreeMap<String, String> phoneBook;

    public PhoneBook() {
        phoneBook = new TreeMap<>();
    }

    public void addContact(String phone, String name) {

        if (isName(name) && isPhoneNumber(phone)) {

            if (!phoneBook.containsKey(name)) {
                if (!getNameByPhone(phone).isEmpty()) {
                    replacePhoneNumber(phone, name);
                } else {
                    phoneBook.put(name, phone);
                    System.out.println(INFO_SAVED_CONTACT);
                }
            }
            else if(phoneBook.containsKey(name)){

                String oldPhone = phoneBook.get(name);

                phoneBook.replace(name, oldPhone, oldPhone + ", " + phone);
                System.out.println(INFO_SAVED_CONTACT);
            }
        }
        else {
            System.out.println("Invalid number or name format.");
        }
    }

    public String getNameByPhone(String phone) {

        String nameAndPhone = "";

        for (String eachName : phoneBook.keySet()) {
            if (phoneBook.get(eachName).contains(phone)) {
                nameAndPhone = eachName + " - " + phoneBook.get(eachName);
            }
        }

        return nameAndPhone;
    }

    public Set<String> getPhonesByName(String name) {

        if (!phoneBook.containsKey(name)) {
            return new TreeSet<>();
        }

        Set<String> nameAndPhone = new TreeSet<>();
        nameAndPhone.add(name + " - " + phoneBook.get(name));

        return Collections.unmodifiableSet(nameAndPhone);
    }

    public Set<String> getAllContacts() {

        if (phoneBook.isEmpty()) {
            return new TreeSet<>();
        }

        Set<String> allContacts = new TreeSet<>();

        for (String eachName : phoneBook.keySet()) {
            allContacts.add(eachName + " - " + phoneBook.get(eachName));
        }

        return Collections.unmodifiableSet(allContacts);
    }

    public boolean isPhoneNumber(String input) {

        final String REGEX_FOR_PHONE_NUMBER = "^((\\+?7?)|8?)((\\s?|-?)|\\s\\()(\\d{10}|" +
                "(\\d{3}((\\s?|-?)|\\)\\s)(\\d{7}|" +
                "\\d{3}(\\s?|-?)(\\d{4}|\\d{2}(\\s?|-?)\\d{2}))))$";
        Pattern phoneNumberRegex = Pattern.compile(REGEX_FOR_PHONE_NUMBER);

        return phoneNumberRegex.matcher(input).matches();
    }

    public boolean isName(String input) {

        final String REGEX_FOR_LETTERS = "[А-Я]([а-я]+)-?[А-Я]?([а-я]+)?";
        Pattern nameRegex = Pattern.compile(REGEX_FOR_LETTERS);

        return nameRegex.matcher(input).matches();
    }

    private void replacePhoneNumber(String phone, String name) {

        String phoneOld = "";
        String nameOfOldPhone = "";

        for (String item : phoneBook.keySet()) {
            if (phoneBook.get(item).contains(phone)) {
                phoneOld = phoneBook.get(item);
                nameOfOldPhone = item;
            }
        }

        String sign = ", ";
        StringBuilder stringBuilder;

        if (phoneOld.contains(sign)) {
            String[] arrayPhones = phoneOld.split(", ");
            stringBuilder = new StringBuilder();

            for (int i = 0; i < arrayPhones.length; i++) {
                if (!arrayPhones[i].contains(phone) && arrayPhones.length < 3)
                    stringBuilder.append(arrayPhones[i]);
                else if (!arrayPhones[i].contains(phone) && arrayPhones.length > 2) {
                    stringBuilder.append(arrayPhones[i]).append(", ");
                }
            }

            if (arrayPhones.length < 3) {
                phoneBook.replace(nameOfOldPhone, phoneOld, stringBuilder.toString());
                phoneBook.put(name, phone);
                System.out.println(INFO_SAVED_CONTACT);
            } else {
                String substringPhone = stringBuilder.toString().substring(0, stringBuilder.lastIndexOf(sign));
                phoneBook.replace(nameOfOldPhone, phoneOld, substringPhone);
                phoneBook.put(name, phone);
                System.out.println(INFO_SAVED_CONTACT);
            }

        } else {
            phoneBook.remove(nameOfOldPhone);
            phoneBook.put(name, phone);
            System.out.println(INFO_SAVED_CONTACT);
        }
    }
}