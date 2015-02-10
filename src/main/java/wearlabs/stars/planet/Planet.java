package wearlabs.stars.planet;

import wearlabs.stars.Vector3;

public class Planet {
    private Vector3 positionVector;

    public Planet(Vector3 positionVector) {
        this.positionVector = positionVector;
    }

    public Vector3 getPositionVector() {
        return positionVector;
    }

    public void setPositionVector(Vector3 positionVector) {
        this.positionVector = positionVector;
    }
}
