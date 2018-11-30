import counters.Counter;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

/**
 * Тест для заданного счётчика {@link Counter}.
 * <p>
 * Проверяется, что при кокурентном увеличении счетчика NUMBER_OF_THREADS потоками, обращающимся к счетчику
 * NUMBER_OF_CYCLES раз, итоговое значение счетчика равно NUMBER_OF_THREADS * NUMBER_OF_CYCLES.
 *
 * @author Роман Агниев
 * @since 28.11.2018
 */
abstract class BaseCounterTest {

    private static final int NUMBER_OF_THREADS = 8;
    private static final int NUMBER_OF_CYCLES = 1_000_000;

    private CountDownLatch latch;
    private ExecutorService executorService;
    private Counter counter;

    @Before
    public void setUp() {
        latch = new CountDownLatch(NUMBER_OF_THREADS);
        executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        setUpCounter();
    }

    @Test
    public void incrementAndGet() {
        execute();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int expected = NUMBER_OF_CYCLES * NUMBER_OF_THREADS;
        assertEquals(expected, counter.get());
    }

    abstract void setUpCounter();

    void setCounter(Counter counter) {
        this.counter = counter;
    }

    private void execute() {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < NUMBER_OF_CYCLES; j++) {
                    counter.incrementAndGet();
                }
                latch.countDown();
            });
        }
    }
}
