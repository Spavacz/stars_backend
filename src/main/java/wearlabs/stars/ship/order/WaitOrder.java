package wearlabs.stars.ship.order;

import wearlabs.stars.ship.Ship;

public class WaitOrder implements ShipOrder {

    private final static int DURATION = 1000;
    private final Ship ship;

    public WaitOrder(Ship ship) {
        this.ship = ship;
    }

    @Override
    public void execute() {
        try {
            ship.report("I'm waiting");
            Thread.sleep(DURATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ship.useFuel(1);
    }
}
