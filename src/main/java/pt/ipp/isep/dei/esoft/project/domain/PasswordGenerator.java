package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Random;

public class PasswordGenerator implements Serializable {

    public PasswordGenerator() {
    }

    public static String generatePwd() {
        Random rand = new Random();
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        StringBuilder password = new StringBuilder();

        // Add 3 uppercase letters
        for (int i = 0; i < 3; i++) {
            int index = rand.nextInt(uppercase.length());
            password.append(uppercase.charAt(index));
        }

        // Add 2 digits
        for (int i = 0; i < 2; i++) {
            int index = rand.nextInt(digits.length());
            password.append(digits.charAt(index));
        }

        // Add 2 lowercase letters
        for (int i = 0; i < 2; i++) {
            int ascii = rand.nextInt(26) + 97;
            char letter = (char) ascii;
            password.append(letter);
        }

        // Shuffle the characters in the password
        for (int i = 0; i < password.length(); i++) {
            int index = rand.nextInt(password.length());
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(index));
            password.setCharAt(index, temp);
        }

        return password.toString();
    }

}
