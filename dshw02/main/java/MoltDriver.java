public class MoltDriver implements Comparable <MoltDriver> {
    int id;
    String name;
    int nextAvailableTimeForDelivery;
    int OrdersDelivered;

    public MoltDriver(int id, String name, int nextAvailableTimeForDelivery) {
        this.id = id;
        this.name = name;
        this.nextAvailableTimeForDelivery = nextAvailableTimeForDelivery;
        this.OrdersDelivered = 0;
    }

    public void incrementOrdersDelivered() {
        this.OrdersDelivered++;
    }

    public int getOrdersDelivered() {
        return this.OrdersDelivered;
    }

    public int getNextAvailableTimeForDelivery() {
        return this.nextAvailableTimeForDelivery;
    }

    public void setNextAvailableTimeForDelivery(int nextAvailableTimeForDelivery) {
        this.nextAvailableTimeForDelivery = nextAvailableTimeForDelivery;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return ("The Driver: " + this.name + " has orders delivered: " + this.OrdersDelivered + "and will available for delivery in: " + this.nextAvailableTimeForDelivery)+ " minutes.";
    }
    //Returns 1 if current driver's next available time for delivery is larger than the other driver,
    //Returns -1 if current driver's next available time for delivery is smaller than the other driver
    //Returns 0 if they are the same.
    public int compareTo(MoltDriver o) {
        if (this.getNextAvailableTimeForDelivery() > o.getNextAvailableTimeForDelivery() ) return 1;
        else if( this.getNextAvailableTimeForDelivery() < o.getNextAvailableTimeForDelivery()) return -1;
        else return 0;
    }
}
