package wearlabs.stars.ship;

import org.junit.Assert;
import org.junit.Test;
import wearlabs.stars.Vector3;
import wearlabs.stars.planet.Planet;

public class PlanetTest {

    @Test
    public final void fetchPlanetObject() {
        Planet planet = Planet.fetchPlanet("earth");
        Assert.assertEquals("check name", "earth", planet.getName());
        Assert.assertTrue("check position", Vector3.ZERO.equals(planet.getPositionVector()));
    }
}
