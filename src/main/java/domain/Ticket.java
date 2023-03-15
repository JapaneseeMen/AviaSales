package domain;

public class Ticket implements Comparable<Ticket> {
    public Ticket(int id, int payment, String from, String to, int travelTime) {
        this.id = id;
        this.payment = payment;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }

    private int id;
    private int payment;
    private String from;
    private String to;
    private int travelTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.payment < o.payment) {
            return -1;
        } else if (this.payment > o.payment) {
            return 1;
        } else {
            return 0;
        }
    }
}
