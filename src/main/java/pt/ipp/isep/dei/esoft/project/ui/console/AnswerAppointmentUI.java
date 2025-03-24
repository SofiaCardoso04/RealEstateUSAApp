package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementDTO;
import pt.ipp.isep.dei.esoft.project.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.INTERFACES.Email;
import pt.ipp.isep.dei.esoft.project.Mappers.VisitRequestMapper;
import pt.ipp.isep.dei.esoft.project.application.controller.AnswerAppointmentController;
import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * User interface class for answering appointments.
 * Implements the Runnable interface to allow execution in a separate thread.
 */
public class AnswerAppointmentUI implements Runnable{
    private final AnswerAppointmentController controller = new AnswerAppointmentController();
    private Advertisement advertisements=null;
    /**
     * Retrieves the AnswerAppointmentController instance used by the UI.
     *
     * @return The AnswerAppointmentController instance.
     */
    private AnswerAppointmentController getController() {
        return controller;
    }
    private VisitRequestDTO visitRequestDTO= null;
    /**
     * Runs the AnswerAppointmentUI logic.
     * Prompts the user for confirmation and retrieves appointment details.
     * Executes based on user confirmation.
     */
    public void run(){
        String typedResponse=null;
        ArrayList<AdvertisementDTO> list = controller.getAdvertisementsDTOs();
        ClientDTO clientDTO = controller.getClientDTO();



        advertisements = controller.getAdvertisementByClientEmail(clientDTO.getEmailAddress(), controller.getVisitRequestDTOs());
        visitRequestDTO= controller.getVisitRequest(advertisements,controller.getVisitRequestDTOs());


        displayAgentInfo(advertisements);
        displayVisitRequestInfo(visitRequestDTO);


        controller.sendNotification("The client"+clientDTO.getName()+"is seeing the appointment request");




        boolean confirmation = Utils.confirm("Please confirm if you want to accept the appointment proposed: (Yes/No)");
        if (confirmation) {
            System.out.println("Your appointment is set");

        }
        else {
            typedResponse = Utils.readLineFromConsole("Write the reason for not accepting the proposed appointment");
        }




    }
    /**
     * Displays the information of an agent and the associated advertisement.
     *
     * @param advertisements the Advertisement object containing the agent and property information
     */
    public void displayAgentInfo(Advertisement advertisements){

        System.out.println("The agent name:"+advertisements.getAgent().getName());
        System.out.println("The agent's phone number:"+advertisements.getAgent().getPhoneNumber());
        System.out.println("The property info:"+advertisements.getProperty().toString());

    }

    /**
     * Displays the information of a visit request.
     *
     * @param visitRequestDTO the VisitRequestDTO object containing the visit request information
     */
    public void displayVisitRequestInfo(VisitRequestDTO visitRequestDTO){

        System.out.println("Appointment date:"+visitRequestDTO.getDate());
        System.out.println("Appointment starting time:"+visitRequestDTO.getStartTime());
        System.out.println("Appointment end time:"+visitRequestDTO.getEndTime());

    }

}
