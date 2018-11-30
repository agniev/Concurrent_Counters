package counters;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Счётчик c "честной" блокировкой (соблюдающей очередность при захвате монитора)
 * при передачи в контруктор флага {@code true}, иначе - очерёдность при блокировке не соблюдается.
 *
 * @author Роман Агниев
 * @since 27.11.2018
 */
public class ReentrantCounter implements Counter {

    private int counter = INITIAL_VALUE;

    private ReentrantLock counterLock;

    public ReentrantCounter(boolean isFair) {
        counterLock = new ReentrantLock(isFair);
    }

    @Override
    public int incrementAndGet() {
        counterLock.lock();
        try {
            return ++counter;
        } finally {
            counterLock.unlock();
        }
    }

    @Override
    public int get() {
        return counter;
    }
}
