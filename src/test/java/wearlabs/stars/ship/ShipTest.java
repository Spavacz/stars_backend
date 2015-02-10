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
        Assert.assertEquals("x", new Vector3(0, 0, 0).x, ship.getPositionVector().x);
        Assert.assertEquals("y", new Vector3(0,0,0).y, ship.getPositionVector().y);
        Assert.assertEquals("z", new Vector3(0, 0, 0).z, ship.getPositionVector().z);
    }

    // ship can orbit planet
    @Test
    public final void shipCanOrbitPlanet() {
        Ship ship = Ship.createShip("test");
        Optional<Planet> planet = Optional.of(new Planet(new Vector3(1,2,3)));

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
}
