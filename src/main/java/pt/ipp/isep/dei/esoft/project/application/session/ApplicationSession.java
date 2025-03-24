package pt.ipp.isep.dei.esoft.project.application.session;

import pt.ipp.isep.dei.esoft.project.Adapters.EmailAdapter;
import pt.ipp.isep.dei.esoft.project.INTERFACES.Email;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationSession {
    private AuthenticationRepository authenticationRepository = null;
    private static final String CONFIGURATION_FILENAME = "src/main/resources/config.properties";
    private static final String COMPANY_DESIGNATION = "Company.Designation";

    /**
     * Constructs an instance of the ApplicationSession.
     */
    public ApplicationSession() {
        this.authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        Properties props = getProperties();
    }

    /**
     * Retrieves the current user session.
     *
     * @return the current user session
     */
    public UserSession getCurrentSession() {
        pt.isep.lei.esoft.auth.UserSession userSession = this.authenticationRepository.getCurrentUserSession();
        return new UserSession(userSession);
    }

    /**
     * Retrieves the email service based on the configured value.
     *
     * @return the email service
     * @throws IOException            if an I/O error occurs
     * @throws ClassNotFoundException if the specified email service class is not found
     * @throws IllegalAccessException if the class or its nullary constructor is not accessible
     * @throws InstantiationException if the class represents an abstract class, an interface, an array class, a primitive type, or void; or if the class has no nullary constructor
     */
    public Email getEmailService() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String email = "pt.ipp.isep.dei.esoft.project.application.session." + getEmail();
        Class<?> className = Class.forName(email);

        if (className == gmail.class) {
            gmail gmail = new gmail();
            return new EmailAdapter(gmail);
        } else {
            return (Email) className.newInstance();
        }
    }

    private String getEmail() throws IOException {
        String fileName = "src/main/resources/config.properties";
        InputStream inputStream = new FileInputStream(fileName);
        String algorithmName = "";
        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            algorithmName = properties.getProperty("emailService");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return algorithmName;
    }

    private Properties getProperties() {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(COMPANY_DESIGNATION, "Real Estate USA");

        // Read configured values
        try {
            InputStream in = new FileInputStream(CONFIGURATION_FILENAME);
            props.load(in);
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return props;
    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static ApplicationSession singleton = null;

    /**
     * Returns the singleton instance of the ApplicationSession.
     *
     * @return the ApplicationSession instance
     */
    public static ApplicationSession getInstance() {
        if (singleton == null) {
            synchronized (ApplicationSession.class) {
                singleton = new ApplicationSession();
            }
        }
        return singleton;
    }
}