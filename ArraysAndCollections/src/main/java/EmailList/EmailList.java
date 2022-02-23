package EmailList;

import java.util.*;
import java.util.regex.Pattern;

public class EmailList {

    private TreeSet<String> emailList;

    public EmailList() {
        emailList = new TreeSet<>();
    }

    public void add(String email) {

        if (isEmailValid(email)) {

            String formattedEmail = email.toLowerCase(Locale.ROOT);

            if (emailList.contains(formattedEmail)) {
                System.out.println("E-mail address " + "\"" + email + "\" already on the list. Also in " +
                        "this program, emails in different cases are considered the same.");
            } else {
                emailList.add(formattedEmail);
                System.out.println("E-mail address " + "\"" + email + "\" successfully added to the list.");
            }

        } else {
            System.out.println(Main.WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {

        List<String> sortedEmails = new ArrayList<String>(emailList);

        return Collections.unmodifiableList(sortedEmails);
    }

    // method determines input email to valid with regex
    private boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
                        "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*" +
                        "|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|" +
                        "\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+" +
                        "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.)" +
                        "{3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:" +
                        "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|" +
                        "\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
                        "+)\\])",
                Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }

}
