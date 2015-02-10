package wearlabs.stars.ship.order;

import wearlabs.stars.ship.Ship;

public class RefuelOrder implements ShipOrder {

    private final static int DURATION = 10000;
    private final Ship ship;

    public RefuelOrder(Ship ship) {
        this.ship = ship;
    }

    @Override
    public void execute() {
        try {
            ship.report("Time to refuel.");
            Thread.sleep(DURATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ship.refuel();
    }
}
