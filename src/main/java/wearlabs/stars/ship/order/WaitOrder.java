package wearlabs.stars.ship.order;

import wearlabs.stars.ship.Ship;

public class WaitOrder extends ShipOrder {

    public WaitOrder(Ship ship) {
        super(ship);
    }

    @Override
    public boolean execute() {
        super.execute();
        ship.useFuel(1);
        return true;
    }

    @Override
    public String toString() {
        return "I'm waiting for " + DURATION + "ms";
    }
}
