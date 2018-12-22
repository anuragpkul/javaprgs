package dailycoding.even_odd_singleton;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This problem was asked by Microsoft.
 *
 * Implement the singleton pattern with a twist.
 * First, instead of storing one instance, store two instances.
 * And in every even call of getInstance(), return the first instance
 * and in every odd call of getInstance(), return the second instance.
 */
public enum EvenOddSingleton {
    EVEN,  ODD;
    volatile static Integer evenOddCnt = 1;
    private static final Semaphore mutex =  new Semaphore(1);;

    public static EvenOddSingleton getInstance(){
        EvenOddSingleton evenOddSingleton = null;
        try {
            mutex.acquire();
            switch (evenOddCnt) {
                case 1:
                    evenOddSingleton = ODD;
                    evenOddCnt = evenOddCnt + 1;
                    break;
                case 2:
                    evenOddSingleton = EVEN;
                    evenOddCnt = evenOddCnt - 1;
            }
        }
        catch (InterruptedException ex){
            System.out.println(ex.getStackTrace());
        }
        finally {
            mutex.release();
        }

        return evenOddSingleton;
    }
}
