package wearlabs.stars.ship.order;

import wearlabs.stars.PropertiesCache;
import wearlabs.stars.ship.Ship;

public class RefuelOrder extends ShipOrder {

    private static final int REFUEL_AMOUNT = PropertiesCache.getInstance().getIntProperty("order.refuel.amount");

    public RefuelOrder(Ship ship) {
        super(ship);
    }

    @Override
    public boolean execute() {
        super.execute();
        ship.addFuel(REFUEL_AMOUNT);
        return ship.getFuel() == ship.getMaxFuel();
    }

    @Override
    public String toString() {
        return "Refueling, current tank " + ship.getFuel() + "/" + ship.getMaxFuel();
    }
}
