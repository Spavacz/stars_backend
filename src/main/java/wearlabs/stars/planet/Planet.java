package wearlabs.stars.planet;

import wearlabs.stars.Vector3;

public class Planet {
    private Vector3 positionVector;
    private String name;

    public Planet(String name, Vector3 positionVector) {
        this.name = name;
        this.positionVector = positionVector;
    }

    public static Planet fetchPlanet(String name) {
        return new Planet(name, new Vector3(0, 0, 0));
    }

    public Vector3 getPositionVector() {
        return positionVector;
    }

    public String getName() {
        return name;
    }
}
