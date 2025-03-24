package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Bootstrap implements Runnable {
private Store store=new Store(new Address("RUA", "city", "Porto", "12345"), "1", "345-496-8432", "USA", "USA@store.com");
private Store store1=new Store(new Address("RUA", "city", "Porto", "12345"), "2", "345-496-8432", "USA", "USA@store.com");


    ;
    //Add some task categories to the repository as bootstrap
    public void run() {
        deserializeObjects();
        addUsers();
        //addTaskCategories();
        //addOrganization();
        addStore();
        addRoles();
        addAccount();
        addProperty();
        addClients();
        addEmployees();
        addAdvertisementRequests();
        addOrders();
        addVisitRequests();
    }

    private void addStore() {
        StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();
        store.createEmployee("Agent", "234565653", "333-33-3333", "agent@this.app", "999-999-9999", new OrganizationRole("Agent"), new Address("rua", "city", "district", "22222"), store);
        storeRepository.addStore(store);
        storeRepository.addStore(store1);
        ArrayList<OrganizationRole> roles = new ArrayList<>();
        roles.add(new OrganizationRole("System Administrator"));
        roles.add(new OrganizationRole("Agent"));
        roles.add(new OrganizationRole("Store Manager"));
        roles.add(new OrganizationRole("Store Network Manager"));

    }

    private void addAccount() {
        AccountRepository accountRepository = Repositories.getInstance().getAccountRepository();
        accountRepository.addAccount(new Account("Jorge", "222222222", "333-33-3333", "user@gmail.com", "333-333-3333", "ola"));
    }

    public void addProperty() {
        //get advertisement repository
        AdvertisementRepository advertisementRepository = Repositories.getInstance().getAdvertisementRepository();
        advertisementRepository.addAdvertisement(new Advertisement(new Employee("Jorge", "123412489", "333-22-4444", "agent@this.app", "333-333-4444"),new Client("Jorge", "123456789", "333-22-4444", "user@gmail.com", "333-333-4444"), 1, new Property(20, 30, "ola", new Address("rua combatentes", "porto", "porto", "12344")), "land", new Commission(1200.0), "rent", "2022/08/20", 90000));
        advertisementRepository.addAdvertisement(new Advertisement(new Employee("Jorge", "123456789", "333-22-4444", "agent@this.app", "333-333-4444"),new Client("Jorge", "123456789", "333-22-4444", "user@gmail.com", "333-333-4444"), 2,  new Property(20, 30, "ola", new Address("rua salvador", "povoa", "porto", "12344")), "house", new Commission(20), "sale", "2023/08/27", 15000));
        advertisementRepository.addAdvertisement(new Advertisement(new Employee("Jorge", "122356789", "333-22-4444", "agent@this.app", "333-333-4444"),new Client("Jorge", "123456789", "333-22-4444", "user@gmail.com", "333-333-4444"), 3, new Property(20, 30, "ola", new Address("rua monteiro", "benfica", "lisboa", "12344")), "apartment", new Commission(1900.0), "rent", "2022/11/22", 70000));
        advertisementRepository.addAdvertisement(new Advertisement(new Employee("Jorge", "123453389", "333-22-4444", "agent@this.app", "333-333-4444"),new Client("Jorge", "123456789", "333-22-4444", "user@gmail.com", "333-333-4444"), 4, new Property(20, 30, "ola", new Address("rua laranjeiras", "arouca", "aveiro", "12344")), "land", new Commission(40), "sale", "2023/12/24", 1200000));
        advertisementRepository.addAdvertisement(new Advertisement(new Employee("Jorge", "098766789", "333-22-4444", "agent@this.app", "333-333-4444"),new Client("Jorge", "123456789", "333-22-4444", "user@gmail.com", "333-333-4444"), 5, new Property(20, 30, "ola", new Address("rua fresca", "matosinhos", "porto", "12344")), "house", new Commission(2500.0), "rent", "2022/12/30", 30000));
        advertisementRepository.addAdvertisement(new Advertisement(new Employee("Jorge", "098766789", "333-22-4444", "agent@this.app", "333-333-4444"),new Client("Jorge", "123456789", "333-22-4444", "client@this.app", "333-333-4444"), 6, new Property(20, 30, "ola", new Address("rua stome", "braga", "braga", "12344")), "house", new Commission(2500.0), "sale", "2022/12/31", 30000));

    }

    /*private void addOrganization() {
        //TODO: add organizations bootstrap here
        //get organization repository
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        Organization organization = new Organization("Real Estate USA");
        //organization.addEmployee(new Employee("admin@this.app"));
        //organization.addEmployee(new Employee("employee@this.app"));
        organizationRepository.add(organization);
    }*/

    private void addRoles() {
        RoleRepository roleRepository = Repositories.getInstance().getRoleRepository();
        roleRepository.addEmployeeRole(new OrganizationRole("Agent"));
    }

    /*private void addTaskCategories() {
        //TODO: add bootstrap Task Categories here

        //get task category repository
        TaskCategoryRepository taskCategoryRepository = Repositories.getInstance().getTaskCategoryRepository();
        taskCategoryRepository.add(new TaskCategory("Analysis"));
        taskCategoryRepository.add(new TaskCategory("Design"));
        taskCategoryRepository.add(new TaskCategory("Implementation"));
        taskCategoryRepository.add(new TaskCategory("Development"));
        taskCategoryRepository.add(new TaskCategory("Testing"));
        taskCategoryRepository.add(new TaskCategory("Deployment"));
        taskCategoryRepository.add(new TaskCategory("Maintenance"));
    }*/

    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE, AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_AGENT, AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_CLIENT, AuthenticationController.ROLE_CLIENT);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_NETWORKMANAGER, AuthenticationController.ROLE_NETWORKMANAGER);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_STOREMANAGER, AuthenticationController.ROLE_STOREMANAGER);
        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin", AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd", AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserWithRole("Jorge", "agent@this.app", "agent", AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserWithRole("Client" , "client@this.app", "client", AuthenticationController.ROLE_CLIENT);
        authenticationRepository.addUserWithRole("Network Manager" , "network@this.app", "network", AuthenticationController.ROLE_NETWORKMANAGER);
        authenticationRepository.addUserWithRole("Joao", "joao@gmail.com", "joao", AuthenticationController.ROLE_CLIENT);
        authenticationRepository.addUserWithRole("Miguel", "miguel@gmail.com", "miguel", AuthenticationController.ROLE_CLIENT);
        authenticationRepository.addUserWithRole("Francisco", "francisco@gmail.com", "francisco", AuthenticationController.ROLE_CLIENT);
        authenticationRepository.addUserWithRole("Store Manager", "store@gmail.com", "store", AuthenticationController.ROLE_STOREMANAGER);


    }

    private void addClients() {
        ClientRepository clientRepository = Repositories.getInstance().getClientRepository();
        clientRepository.addClient(new Client("Name", "123456789", "123-12-1234", "client@this.app", "123-123-1234"));
        clientRepository.addClient (new Client("Miguel", "876543219", "321-21-4321", "miguel@gmail.com", "321-321-4321"));
        clientRepository.addClient (new Client("Joao", "234567899", "234-23-2345", "joao@gmail.com", "234-234-2345"));
        clientRepository.addClient (new Client("Francisco", "567812349", "789-89-6789", "francisco@gmail.com", "789-789-6789"));

    }

    private void addAdvertisementRequests(){
        AdvertisementRequestRepository advertisementRequestRepository = Repositories.getInstance().getAdvertisementRequestRepository();
        advertisementRequestRepository.addAdvertisementRequest(new AdvertisementRequest("client1@this.app", new Store(new Address("RUA", "city", "Porto", "12345"), "1", "345-496-8432", "USA", "USA@store.com"), new Employee("name", "123456789", "123-12-1234", "agent@gamil.com", "123-123-1234", new OrganizationRole("Agent"), new Address("RUA", "city", "Porto", "12345"), new Store(new Address("RUA", "city", "Porto", "12345"), "1", "345-496-8432", "USA", "USA@store.com")), new Property(20, 30, "ola", new Address("rua combatentes", "porto", "porto", "12344")), "land", "rent", 2000,"2023/02/20"));
        advertisementRequestRepository.addAdvertisementRequest(new AdvertisementRequest("client@this.app", new Store(new Address("RUA", "city", "Porto", "12345"), "1", "345-496-8432", "USA", "USA@store.com"), new Employee("name", "123456789", "123-12-1234", "agent@gamil.com", "123-123-1234", new OrganizationRole("Agent"), new Address("RUA", "city", "Porto", "12345"), new Store(new Address("RUA", "city", "Porto", "12345"), "1", "345-496-8432", "USA", "USA@store.com")), new Property(20, 30, "ola", new Address("rua combatentes", "porto", "porto", "12344")), "land", "rent", 4500,"2023/08/02"));
    }

    private void addEmployees() {
        EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
        AgentListRepository agentListRepository=Repositories.getInstance().getAgentListRepository();
        employeeRepository.addEmployee(new Employee("Jorge", "123456789", "123-12-1234", "agent@this.app", "123-123-1234",
                new OrganizationRole("Agent"), new Address("street", "city", "district", "12345"),
                new Store(new Address("RUA", "city", "Porto", "12345"), "1", "345-496-8432", "USA", "USA@store.com")));
        NetworkManager networkManager = new NetworkManager("Network Manager","123456789","123-12-1234","network@this.app","123-123-1234",new OrganizationRole("Network Manager"),store);
        networkManager.addStore(store1);
        employeeRepository.addEmployee(networkManager);
//aqui em baixo
        agentListRepository.addAgent(new Agent("Agent2","123456789","123-12-1234","agent1@this.app","123-123-1234",new OrganizationRole("Agent"),new Address("RUA", "city", "Porto", "12345"),store));
    }

    public void addOrders(){
        OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
        ClientRepository clientRepository = Repositories.getInstance().getClientRepository();
        AdvertisementRepository advertisementRepository = Repositories.getInstance().getAdvertisementRepository();

        Client client1 = clientRepository.getClientsList().get(0);
        Client client2 = clientRepository.getClientsList().get(1);
        Client client3 = clientRepository.getClientsList().get(2);
        Client client4 = clientRepository.getClientsList().get(3);

        Advertisement advertisement1 = advertisementRepository.getAdvertisements().get(0);
        Advertisement advertisement2 = advertisementRepository.getAdvertisements().get(1);
        Advertisement advertisement3 = advertisementRepository.getAdvertisements().get(2);
        Advertisement advertisement4 = advertisementRepository.getAdvertisements().get(3);
        Advertisement advertisement5 = advertisementRepository.getAdvertisements().get(4);

        /*orderRepository.addOrder(new PurchaseOrder(10000.0, client1, advertisement3));
        orderRepository.addOrder(new PurchaseOrder(20000.0, client2, advertisement4));
        orderRepository.addOrder(new PurchaseOrder(40000.0, client3, advertisement5));
        orderRepository.addOrder(new PurchaseOrder(30000.0, client1, advertisement2));
        orderRepository.addOrder(new PurchaseOrder(50000.0, client4, advertisement1));*/

        orderRepository.addOrder(new PurchaseOrder(10000.0, client1, new Advertisement(new Employee("Jorge", "123412489", "333-22-4444", "agent@this.app", "333-333-4444"),new Client("Jorge", "123456789", "333-22-4444", "user@gmail.com", "333-333-4444"), 1, new Property(20, 30, "ola", new Address("rua combatentes", "porto", "porto", "12344")), "land", new Commission(1900.0), "rent", "2022/08/20",90000)));
        orderRepository.addOrder(new PurchaseOrder(20000.0, client2, new Advertisement(new Employee("Jorge", "123412489", "333-22-4444", "agent@this.app", "333-333-4444"),new Client("Jorge", "123456789", "333-22-4444", "user@gmail.com", "333-333-4444"), 2, new Property(2000, 3000, "ola", new Address("street", "lisboa", "lisboa", "12344")), "house", new Commission(20), "sale", "2021/08/20", 180000)));
    }

    public void addVisitRequests(){
        ScheduleVisitRepository visitRepository = Repositories.getInstance().getScheduleVisitRepository();
        AdvertisementRepository advertisementRepository = Repositories.getInstance().getAdvertisementRepository();

        Advertisement advertisement1 = advertisementRepository.getAdvertisements().get(0);
        Advertisement advertisement2 = advertisementRepository.getAdvertisements().get(1);
        Advertisement advertisement3 = advertisementRepository.getAdvertisements().get(2);
        Advertisement advertisement4 = advertisementRepository.getAdvertisements().get(3);
        Advertisement advertisement5 = advertisementRepository.getAdvertisements().get(4);
        Advertisement advertisement6 = advertisementRepository.getAdvertisements().get(5);

        visitRepository.addVisit(new VisitRequest(advertisement1,LocalDate.parse("2023/06/08", DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalTime.parse("16:00", DateTimeFormatter.ofPattern("HH:mm")),LocalTime.parse("17:00", DateTimeFormatter.ofPattern("HH:mm"))));
        visitRepository.addVisit(new VisitRequest(advertisement2,LocalDate.parse("2023/08/12", DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalTime.parse("16:00", DateTimeFormatter.ofPattern("HH:mm")),LocalTime.parse("17:00", DateTimeFormatter.ofPattern("HH:mm"))));
        visitRepository.addVisit(new VisitRequest(advertisement3,LocalDate.parse("2023/06/23", DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalTime.parse("16:00", DateTimeFormatter.ofPattern("HH:mm")),LocalTime.parse("17:00", DateTimeFormatter.ofPattern("HH:mm"))));
        visitRepository.addVisit(new VisitRequest(advertisement4,LocalDate.parse("2023/07/09", DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalTime.parse("16:00", DateTimeFormatter.ofPattern("HH:mm")),LocalTime.parse("17:00", DateTimeFormatter.ofPattern("HH:mm"))));
        visitRepository.addVisit(new VisitRequest(advertisement5,LocalDate.parse("2023/07/10", DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalTime.parse("16:00", DateTimeFormatter.ofPattern("HH:mm")),LocalTime.parse("17:00", DateTimeFormatter.ofPattern("HH:mm"))));
        visitRepository.addVisit(new VisitRequest(advertisement6,LocalDate.parse("2023/07/13", DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalTime.parse("16:00", DateTimeFormatter.ofPattern("HH:mm")),LocalTime.parse("17:00", DateTimeFormatter.ofPattern("HH:mm"))));

    }

    public void deserializeObjects() {
        new File("./Serialization").mkdir();

        Repositories.getInstance().deserializeRepository();
        /*Repositories.getInstance().getScheduleVisitRepository().deserializeRepository();
        Repositories.getInstance().getAccountRepository().deserializeRepository();
        Repositories.getInstance().getAddressRepository().deserializeRepository();
        Repositories.getInstance().getAdvertisementRepository().deserializeRepository();
        Repositories.getInstance().getAdvertisementRequestRepository().deserializeRepository();
        Repositories.getInstance().getAgentListRepository().deserializeRepository();
        Repositories.getInstance().getClientRepository().deserializeRepository();
        Repositories.getInstance().getEmployeeRepository().deserializeRepository();
        Repositories.getInstance().getOrderRepository().deserializeRepository();
        Repositories.getInstance().getPropertyRepository().deserializeRepository();
        Repositories.getInstance().getRoleRepository().deserializeRepository();
        Repositories.getInstance().getStoreRepository().deserializeRepository();*/
    }
}
