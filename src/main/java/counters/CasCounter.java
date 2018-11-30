package counters;

/**
 * Реализация счетчика без блокировки с методом Сравнение и замена.
 *
 * @author Роман Агниев
 * @since 28.11.2018
 */
public class CasCounter implements Counter {
    private SimulatedCas value = new SimulatedCas(INITIAL_VALUE);

    @Override
    public int incrementAndGet() {
        int oldValue = value.getValue();
        while (value.compareAndSwap(oldValue, oldValue + 1) != oldValue)
            oldValue = value.getValue();
        return oldValue + 1;
    }

    @Override
    public int get() {
        return value.getValue();
    }
}
