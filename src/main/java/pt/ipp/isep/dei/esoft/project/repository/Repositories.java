package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;

import java.io.*;
import java.util.Scanner;

/**
 * Represents all the repositories
 */
public class Repositories implements  Serializable {
    private static final Repositories instance = new Repositories();
    transient AuthenticationRepository authenticationRepository = new AuthenticationRepository();
    AddressRepository addressRepository = new AddressRepository();
    AdvertisementRepository advertisementRepository = new AdvertisementRepository();
    AgentListRepository agentListRepository = new AgentListRepository();
    StoreRepository storeRepository = new StoreRepository();
    ClientRepository clientRepository = new ClientRepository();
    PropertyRepository propertyRepository = new PropertyRepository();
    //TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
    //OrganizationRepository organizationRepository = new OrganizationRepository();
    //AuthenticationRepository authenticationRepository = new AuthenticationRepository();
    RoleRepository roleRepository = new RoleRepository();
    AdvertisementRequestRepository advertisementRequestRepository = new AdvertisementRequestRepository();
    AccountRepository registerAccountRepository = new AccountRepository();
    EmployeeRepository employeeRepository = new EmployeeRepository();
    ScheduleVisitRepository scheduleVisitRepository = new ScheduleVisitRepository();
    OrderRepository OrderRepository = new OrderRepository();
    StaticticsRepository StaticticsRepository = new StaticticsRepository();
    AlgorithmRepository algorithmRepository = new AlgorithmRepository();

    private Repositories() {
    }

    /**
     * Get the repositories instance
     * @return the repositories instance
     */
    public static Repositories getInstance() {
        return instance;
    }

    public ScheduleVisitRepository getScheduleVisitRepository() {
        return scheduleVisitRepository;
    }

    /**
     * Get the employee repository
     *
     * @return the employee repository
     */
    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    /**
     * Get the address repository
     *
     * @return the address repository
     */
    public AddressRepository getAddressRepository() {
        return addressRepository;
    }

    /**
     * Get the store repository
     *
     * @return the store repository
     */
    public StoreRepository getStoreRepository() {
        return storeRepository;
    }

    /**
     * Get the advertisement repository
     *
     * @return the advertisement repository
     */
    public AdvertisementRepository getAdvertisementRepository() {
        return advertisementRepository;
    }

    /**
     * Get the client repository
     *
     * @return the client repository
     */
    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    /**
     * Get the agent list repository
     *
     * @return the agent list repository
     */
    public AgentListRepository getAgentListRepository() {
        return agentListRepository;
    }

    /**
     * Get the advertisement request repository
     *
     * @return the advertisement request repository
     */
    public AdvertisementRequestRepository getAdvertisementRequestRepository() {
        return advertisementRequestRepository;
    }

    /**
     * Get the property repository
     *
     * @return the property repository
     */
    public PropertyRepository getPropertyRepository(){
        return propertyRepository;
    }

    /**
     * Get the account repository
     *
     * @return the account repository
     */
    public AccountRepository getAccountRepository() {
        return registerAccountRepository;
    }

    /*public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }*/

    /*public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }*/

    /**
     * Get the authentication repository
     *
     * @return the authentication repository
     */
    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    /**
     * Get the role repository
     *
     * @return the role repository
     */
    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public OrderRepository getOrderRepository() {
        return OrderRepository;
    }
    public StaticticsRepository getStaticticsRepository(){return StaticticsRepository;}
    public AlgorithmRepository getAlgorithmRepository(){return algorithmRepository;}

    private final String REPOSITORIES_SERIALIZATION_FILE_PATH = "Serialization/repositories.ser";

    public boolean deserializeRepository() {
        try {
            FileInputStream fileIn = new FileInputStream(REPOSITORIES_SERIALIZATION_FILE_PATH);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Repositories repositories = (Repositories) objectIn.readObject();

            objectIn.close();
            fileIn.close();

            registerAccountRepository = repositories.getAccountRepository();
            agentListRepository = repositories.getAgentListRepository();
            propertyRepository = repositories.getPropertyRepository();
            roleRepository = repositories.getRoleRepository();
            addressRepository = repositories.getAddressRepository();
            clientRepository = repositories.getClientRepository();
            employeeRepository = repositories.getEmployeeRepository();
            OrderRepository = repositories.getOrderRepository();
            advertisementRequestRepository = repositories.getAdvertisementRequestRepository();
            advertisementRepository = repositories.getAdvertisementRepository();
            scheduleVisitRepository = repositories.getScheduleVisitRepository();
            storeRepository = repositories.getStoreRepository();

        } catch (IOException | ClassNotFoundException e) {
            return false;
        }

        try {
            Scanner scanner = new Scanner(new File("authFacade.txt"));
            AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
            authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
            authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE, AuthenticationController.ROLE_EMPLOYEE);
            authenticationRepository.addUserRole(AuthenticationController.ROLE_AGENT, AuthenticationController.ROLE_AGENT);
            authenticationRepository.addUserRole(AuthenticationController.ROLE_CLIENT, AuthenticationController.ROLE_CLIENT);
            authenticationRepository.addUserRole(AuthenticationController.ROLE_NETWORKMANAGER, AuthenticationController.ROLE_NETWORKMANAGER);
            authenticationRepository.addUserRole(AuthenticationController.ROLE_STOREMANAGER, AuthenticationController.ROLE_STOREMANAGER);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] entry = line.split(";");

                authenticationRepository.addUserWithRole(entry[0],entry[1],entry[2],entry[3]);
            }
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }

    public void serializeRepository() {
        File file = new File(REPOSITORIES_SERIALIZATION_FILE_PATH);
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(instance);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
