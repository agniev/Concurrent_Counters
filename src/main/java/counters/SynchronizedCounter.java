package counters;

/**
 * Реализация счетчика с блокирующим методом.
 *
 * @author Роман Агниев
 * @since 24.11.2018
 */
public class SynchronizedCounter implements Counter {

    private int counter = INITIAL_VALUE;

    @Override
    public synchronized int incrementAndGet() {
        return ++counter;
    }

    @Override
    public int get() {
        return counter;
    }
}
