package wearlabs.stars.ship;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import wearlabs.stars.PropertiesCache;

public class PropertiesCacheTest {

    static PropertiesCache pc;

    @BeforeClass
    public static void init() {
        pc = PropertiesCache.getInstance();
    }

    @Test
    public final void propertiesCacheIsSingleton() {
        Assert.assertEquals(pc, PropertiesCache.getInstance());
    }

    @Test
    public final void whenGetStringThenReturnString() {
        Assert.assertEquals("test", pc.getStringProperty("test.string"));
    }

    @Test
    public final void whenGetIntThenReturnInt() {
        Assert.assertEquals(7, pc.getIntProperty("test.int"));
    }

    @Test
    public final void whenPropertyNotExistThenContainsKeyReturnFalse() {
        Assert.assertFalse(pc.containsKey("not_exists"));
    }

    @Test
    public final void whenPropertyExistThenContainsKeyReturnTrue() {
        Assert.assertTrue(pc.containsKey("test.string"));
    }
}
