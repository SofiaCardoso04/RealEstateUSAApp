package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.OrganizationRole;
import pt.ipp.isep.dei.esoft.project.domain.Store;

import static org.junit.jupiter.api.Assertions.*;

public class AgentListRepositoryTest {
    /*@Test
    void testAddAgent() {
        AgentListRepository repo = new AgentListRepository();
        Agent agent = new Agent("Jorge", "12345678", "333-33-3333", "user@gmail.com", "(222) 222-2222", new OrganizationRole("Agent"), (new Address("Rua da Serra", "Gaia", "Porto", "12345")),
                new Store((new Address("Rua da Serra", "Gaia", "Porto", "12345")), "1", "(333) 333-3333", "store", "user2@gmail.com"));
        assertTrue(repo.addAgent(agent), "Should add agent successfully");
        assertFalse(repo.addAgent(agent), "Should not add agent twice");
        assertFalse(repo.addAgent(null), "Should not add null agent");
    }

    @Test
    void testGetAgent() {
        AgentListRepository repo = new AgentListRepository();
        Agent agent = new Agent("Jorge", "12345678", "333-33-3333", "user@gmail.com", "(222) 222-2222", new OrganizationRole("Agent"), (new Address("Rua da Serra", "Gaia", "Porto", "12345")),
                new Store((new Address("Rua da Serra", "Gaia", "Porto", "12345")), "1", "(333) 333-3333", "store", "user2@gmail.com"));
        repo.addAgent(agent);
        assertTrue(repo.getAgent().contains(agent), "Should return a copy of the agents list");
        assertNotSame(repo.getAgent(), repo.getAgent(), "Should return a new instance each time");
    }*/
}
