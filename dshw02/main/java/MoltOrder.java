public class MoltOrder implements Comparable<MoltOrder> {

    String OrderDescription;
    String name;
    int orderReadyTime;
    int timeNeededForDelivery;
    int priority;

    public MoltOrder(String OrderDescription, String name, int orderReadyTime, int timeNeededForDelivery, int priority) {

        this.OrderDescription = OrderDescription;
        this.name = name;
        this.orderReadyTime = orderReadyTime;
        this.timeNeededForDelivery = timeNeededForDelivery;
        this.priority = priority;
    }

    public String getOrderDescription() {
        return OrderDescription;
    }

    public int getOrderReadyTime() {
        return orderReadyTime;
    }

    public int getTimeNeededForDelivery() {
        return timeNeededForDelivery;
    }

    public String getName() {
        return name;
    }

    public String ToString() {
        return "Order Description: " + OrderDescription + " Customer Name: " + name + " Order Ready: " + orderReadyTime + " Time: " + timeNeededForDelivery + " Priority: " + priority;
    }
    //Returns 1 if the priority of the current order is higher than the other's priority
    //Returns -1 if the priority of the current order is lower than the other's priority
    //Returns 0 if their priority is the same.
    public int compareTo(MoltOrder o) {
    if (this.priority > o.priority) return 1;
    else if (this.priority == o.priority) return 0;
    else return -1;
    }
}

