package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class represents a repository of agents.
 */
public class AgentListRepository implements Serializable {
    /**
     * The list of agents managed by this repository.
     */
    private List<Agent> agentsList = new ArrayList<>();

    /**
     * Add agent to the agents list
     *
     * @param agent the agent
     * @return the agents list
     */
    public boolean addAgent(Agent agent) {
        if (agent == null) {
            return false;
        }

        if (this.agentsList.contains(agent)) {
            return false;
        }

        return this.agentsList.add(agent);
    }

    /**
     * Get the agent
     *
     * @return a copy of the agents list
     */
    public List<Agent> getAgent() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(agentsList);
    }

    public Agent getAgentByEmail(String emailAddress) {
        for (Agent agent : agentsList) {
            if (agent.getEmailAddress().equals(emailAddress)) {
                return agent;
            }
        }
        return null;
    }
}
