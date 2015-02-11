package wearlabs.stars.ship;

import org.junit.Assert;
import org.junit.Test;
import wearlabs.stars.Vector3;
import wearlabs.stars.planet.Planet;

import java.util.Optional;

public class ShipTest {
    // ship has default position in space
    @Test
    public final void whenNewShipThenHasZeroPositionVector() {
        Ship ship = Ship.createShip("test");
        Assert.assertTrue(Vector3.ZERO.equals(ship.getPositionVector()));
    }

    // ship can orbit planet
    @Test
    public final void shipCanOrbitPlanet() {
        Ship ship = Ship.createShip("test");
        Optional<Planet> planet = Optional.of(Planet.fetchPlanet("earth"));

        ship.orbit(planet);
        Assert.assertEquals("ship orbit planet", planet, ship.getOrbit());
        Assert.assertTrue("ship have same position as planet", planet.get().getPositionVector().equals(ship.getPositionVector()));
    }

    // ship launch
    @Test
    public final void whenLaunchThenDoOrders() {
        Ship ship = Ship.createShip("test");
        ship.launchShip();
    }

    @Test
    public final void whenNewShipThenHasNoOrders() {
        Ship ship = Ship.createShip("test");

        Assert.assertFalse("New ship has no orders", ship.hasOrders());
    }
}
