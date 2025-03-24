package pt.ipp.isep.dei.esoft.project.repository;


import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AuthenticationRepository implements Serializable {
    private final AuthFacade authenticationFacade = new AuthFacade();

    public boolean doLogin(String email, String pwd) {
        return authenticationFacade.doLogin(email, pwd).isLoggedIn();
    }

    public void doLogout() {
        authenticationFacade.doLogout();
    }

    public UserSession getCurrentUserSession() {
        return authenticationFacade.getCurrentUserSession();
    }

    public boolean addUserRole(String id, String description) {
        return authenticationFacade.addUserRole(id, description);
    }

    public boolean addUserWithRole(String name, String email, String pwd, String roleId) {
        boolean exists = false;
        try {
            Scanner scanner = new Scanner(new File("authFacade.txt"));

            while (scanner.hasNextLine() && !exists) {
                String line = scanner.nextLine();
                String[] entry = line.split(";");

                if (entry[1].equals(email)) {
                    exists = true;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (!exists) {
            try {
                File fileName = new File("authFacade.txt");
                FileWriter fileWriter = new FileWriter(fileName, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.printf("%s;%s;%s;%s%n", name, email, pwd, roleId);
                printWriter.flush();
                printWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        return authenticationFacade.addUserWithRole(name, email, pwd, roleId);
    }

    public String getCurrentUserEmail() {
        if (authenticationFacade.getCurrentUserSession().isLoggedIn()) {
            return authenticationFacade.getCurrentUserSession().getUserId().getEmail();
        }
        return null;
    }
}
