package wearlabs.stars;

import wearlabs.stars.ship.Ship;

public class Main {

    public static void main(String[] args) {
        Ship.createShip("Falcon").launchShip();
        Ship.createShip("Enterprise").launchShip();
    }
}
