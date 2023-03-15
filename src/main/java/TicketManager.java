import domain.Ticket;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findAll(String to, String from) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getAll()) {
            if (matches(ticket,to) && matchesSecond(ticket,from)){
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }

        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String search) {
        if (ticket.getFrom().contains(search) ) {
            return true;
        } else {
            return false;
        }
    }
        public boolean matchesSecond(Ticket ticket, String search) {
            if ( ticket.getTo().contains(search)) {
                return true;
            } else {
                return false;
            }

    }
    public Ticket[] showAll() {
        Ticket[] result = repo.getAll();
        Arrays.sort(result);
        return result;
    }


}



