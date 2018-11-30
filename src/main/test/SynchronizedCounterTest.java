import counters.SynchronizedCounter;

/**
 * @author Роман Агниев
 * @since 29.11.2018
 */
public class SynchronizedCounterTest extends BaseCounterTest {
    @Override
    void setUpCounter() {
        setCounter(new SynchronizedCounter());
    }
}