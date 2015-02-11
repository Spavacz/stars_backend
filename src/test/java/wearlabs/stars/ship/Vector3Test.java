package wearlabs.stars.ship;

import org.junit.Assert;
import org.junit.Test;
import wearlabs.stars.Vector3;

public class Vector3Test {

    @Test
    public final void whenSameVectorCoordinatesThenVectorsAreEqual() {
        Vector3 v1 = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(1, 2, 3);

        Assert.assertTrue(v1.equals(v2));
        Assert.assertTrue(v2.equals(v1));
    }

    @Test
    public final void whenDifferentVectorCoordinatesThenVectorsAreNotEqual() {
        Vector3 v1 = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(1, 2, 0);

        Assert.assertFalse(v1.equals(v2));
        Assert.assertFalse(v2.equals(v1));
    }

}
