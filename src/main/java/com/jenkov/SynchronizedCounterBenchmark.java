package com.jenkov;

import counters.SynchronizedCounter;

/**
 * @author Роман Агниев
 * @since 28.11.2018
 */
public class SynchronizedCounterBenchmark extends MyBenchmark {

    @Override
    public void prepare() {
        setCounter(new SynchronizedCounter());
    }
}
