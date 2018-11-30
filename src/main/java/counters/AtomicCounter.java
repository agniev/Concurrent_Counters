package counters;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Счётчик с использованием {@link AtomicInteger}, который используют сравнение с обменом (compare-and-swap, CAS),
 * атомарную инструкцию, работающую гораздо быстрее, чем синхронизация с помощью блокировок.
 *
 * @author Роман Агниев
 * @since 24.11.2018
 */
public class AtomicCounter implements Counter {

    private AtomicInteger counter = new AtomicInteger(INITIAL_VALUE);

    @Override
    public int incrementAndGet() {
        return counter.incrementAndGet();
    }

    @Override
    public int get() {
        return counter.get();
    }
}
