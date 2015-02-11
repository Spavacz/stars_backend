package wearlabs.stars;

public class Vector3 {

    public static final Vector3 ZERO = new Vector3(0, 0, 0);

    public double x;
    public double y;
    public double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(Vector3 v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public boolean equals(Vector3 v) {
        return x == v.x && y == v.y && z == v.z;
    }
}
