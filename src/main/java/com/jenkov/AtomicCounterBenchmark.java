package com.jenkov;

import counters.AtomicCounter;

/**
 * @author Роман Агниев
 * @since 28.11.2018
 */
public class AtomicCounterBenchmark extends MyBenchmark {

    @Override
    public void prepare() {
        setCounter(new AtomicCounter());
    }
}
