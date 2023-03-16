import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.Ticket;


import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    private Ticket one = new Ticket(1, 16000, "AAA", "AAB", 220);
    private Ticket two = new Ticket(2, 17000, "AAC", "AAE", 310);
    private Ticket three = new Ticket(3, 18000, "AAA", "AAB", 65);
    private Ticket four = new Ticket(4, 16500, "AAH", "AAI", 750);
    private Ticket five = new Ticket(5, 17000, "AAJ", "AAK", 150);
    private Ticket six = new Ticket(6, 17500, "AAA", "AAB", 100);

    @BeforeEach
    public void setUp() {

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
    }

    @Test
    void mustShowAllTickets() {
        Ticket[] expected = new Ticket[]{one, four, two, five, six, three};
        assertArrayEquals(expected, manager.showAll());
    }

    @Test
    void findExisting() {
        Ticket[] expected = new Ticket[]{one, six, three};
        Ticket[] actual = manager.findAll("AAA", "AAB");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findUncertainty() {
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("AAA", "AAJ");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void mustFindById() {

        repo.removeById(1);
        Ticket[] expected = {six};
        Ticket[] actual = new Ticket[]{repo.findBiId(6)};
        Assertions.assertArrayEquals(expected, actual);

    }
}
