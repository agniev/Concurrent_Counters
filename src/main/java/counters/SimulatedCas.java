package counters;

/**
 * Код, иллюстрирующий ход выполнения (но не характеристики) метода Сравнить и заменить.
 *
 * @author Роман Агниев
 * @since 28.11.2018
 */
class SimulatedCas {
    private int value;

    SimulatedCas(int value) {
        this.value = value;
    }

    synchronized int getValue() {
        return value;
    }

    synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (value == expectedValue)
            value = newValue;
        return oldValue;
    }
}