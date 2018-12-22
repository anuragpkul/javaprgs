package dailycoding.even_odd_singleton;

import org.junit.Assert;
import org.junit.Test;

/**
 * This problem was asked by Microsoft.
 *
 * Implement the singleton pattern with a twist.
 * First, instead of storing one instance, store two instances.
 * And in every even call of getInstance(), return the first instance
 * and in every odd call of getInstance(), return the second instance.
 */
public class EvenOddSingletonTest {

    @Test
    public void testEvenOddSingleton(){
        Assert.assertEquals(EvenOddSingleton.getInstance(),EvenOddSingleton.ODD);
        Assert.assertEquals(EvenOddSingleton.getInstance(),EvenOddSingleton.EVEN);
        Assert.assertEquals(EvenOddSingleton.getInstance(),EvenOddSingleton.ODD);
        Assert.assertEquals(EvenOddSingleton.getInstance(),EvenOddSingleton.EVEN);
    }

}
