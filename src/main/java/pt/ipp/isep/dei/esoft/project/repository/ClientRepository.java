package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.*;
import java.util.ArrayList;

/**
 * This class represents a repository of clients.
 */
public class ClientRepository  implements Serializable{
    private static final String CLIENT_SERIALIZATION_FILE_PATH= "Serialization/Client.ser";
    /**
     * The list of clients managed by this repository.
     */
    private static ArrayList<Client> clients = new ArrayList<>();

    public ArrayList<Client> getClientsList() {
        return clients;
    }

    public boolean validateClient(Client client) {
        return clients.contains(client);
    }

    /**
     * Add client to the agents list
     *
     * @param client the client
     * @return the clients list
     */
    public boolean addClient(Client client) {
        if (client == null) {
            return false;
        }

        if (validateClient(client)) {
            return false;
        }

        return clients.add(client);
    }

    /**
     * This method returns an existing client by its email address.
     * @param emailAddress The email address of client.
     * @return the client
     */
    public Client getClientByEmail(String emailAddress){
        for (Client client : clients){
            if (client.getEmailAddress().equals(emailAddress)){
                return client;
            }
        }
        return null;
    }

    public Client getClientByName(String name){
        for (Client client : clients){
            if (client.getName().equals(name)){
                return client;
            }
        }
        return null;
    }

    public Client createClient(String passportNumber, String taxNumber, String name, String phone, String email) {
        return new Client(name, passportNumber, taxNumber, email, phone);
    }

}
