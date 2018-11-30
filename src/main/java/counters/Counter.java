package counters;

/**
 * @author Роман Агниев
 * @since 27.11.2018
 */
public interface Counter {

    int INITIAL_VALUE = 0;

    /**
     * Увеличивает на единицу текущее значение.
     *
     * @return обновлённое значение
     */
    int incrementAndGet();

    /**
     * Возвращает текущее значение.
     *
     * @return текущее значение
     */
    int get();
}
