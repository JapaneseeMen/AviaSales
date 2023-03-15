import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.Ticket;



import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {
    private TicketRepository repo = new TicketRepository();
    private Ticket one = new Ticket(1, 16000, "AAA", "AAB", 220);
    private Ticket two = new Ticket(2, 17000, "AAC", "AAE", 310);
    private Ticket three = new Ticket(3, 18000, "AAA", "AAB", 65);
    private Ticket four = new Ticket(4, 16500, "AAH", "AAI", 750);
    private Ticket five = new Ticket(5, 19000, "AAJ", "AAK", 150);
    private Ticket six = new Ticket(6, 17500, "AAA", "AAB", 100);

    @Test
    void mustSave() {
        repo.save(one);
        Ticket[] expected = new Ticket[]{one};
        Ticket[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowEmpty() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowNotEmpty() {
        repo.save(one);
        repo.save(two);
        Ticket[] expected = new Ticket[]{one, two};
        Ticket[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }
    @Test

    public void removeByIdWithNoFindId(){


        Assertions.assertThrows(NotFoundException.class, ()->{repo.removeById(55);} );
    }
   @Test
    public void showItemsWithRemoveById() {
        repo.save(one);
        repo.save(two);
        repo.removeById(1);
        Ticket[] expected = {two};
        Ticket[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
