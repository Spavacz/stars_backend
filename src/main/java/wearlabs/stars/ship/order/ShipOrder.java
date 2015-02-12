package wearlabs.stars.ship.order;

import wearlabs.stars.ship.Ship;

public abstract class ShipOrder implements Order {

    protected final static int DURATION = 1000;
    protected final Ship ship;

    public ShipOrder(Ship ship) {
        this.ship = ship;
    }

    public boolean execute() {
        try {
            ship.report(this.toString());
            Thread.sleep(getDuration());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public int getDuration() {
        return DURATION;
    }
}
