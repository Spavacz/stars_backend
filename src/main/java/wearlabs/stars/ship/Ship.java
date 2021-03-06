package wearlabs.stars.ship;

import wearlabs.stars.Vector3;
import wearlabs.stars.planet.Planet;
import wearlabs.stars.ship.order.RefuelOrder;
import wearlabs.stars.ship.order.Order;
import wearlabs.stars.ship.order.WaitOrder;

import java.util.ArrayList;
import java.util.Optional;

public class Ship {

    private final String name;
    private Optional<Planet> orbit = Optional.empty();
    private Vector3 positionVector = new Vector3(0, 0, 0);
    private ArrayList<Order> orders = new ArrayList<>();
    private float fuel = 10;
    private boolean destroyed = false;
    private float maxFuel = 10;

    private Ship(String name) {
        this.name = name;
    }

    public static Ship createShip(String name) {
        return new Ship(name);
    }

    public void launchShip() {
        new Thread(() -> {
            for (; ; ) {
                update();
                if (destroyed) {
                    return;
                }
            }
        }).start();
    }

    private synchronized void update() {
        if (!hasOrders()) {
            assignOrders();
        }
        executeOrder();
    }

    private void executeOrder() {
        if (hasOrders() && orders.get(0).execute()) {
            orders.remove(0);
        }
    }

    private void assignOrders() {
        if (fuel <= 1) {
            orders.add(new RefuelOrder(this));
        } else {
            orders.add(new WaitOrder(this));
        }
    }

    public Vector3 getPositionVector() {
        return positionVector;
    }

    public void orbit(Optional<Planet> planet) {
        orbit = planet;
        if (planet.isPresent()) {
            positionVector.set(planet.get().getPositionVector());
        }
    }

    public Optional<Planet> getOrbit() {
        return orbit;
    }

    public boolean hasOrders() {
        return !orders.isEmpty();
    }

    public void refuel() {
        fuel += 1;
    }

    public void useFuel(int amount) {
        fuel -= amount;
        if (fuel < 0) {
            destroyed = true;
        }
    }

    public void report(String message) {
        System.out.println(Thread.currentThread().getName() + ": " + name + " reporting Sir! " + message);
    }

    public void addFuel(int refuelAmount) {
        fuel += refuelAmount;
        if (fuel > maxFuel) fuel = maxFuel;
    }

    public float getFuel() {
        return fuel;
    }

    public float getMaxFuel() {
        return maxFuel;
    }
}
