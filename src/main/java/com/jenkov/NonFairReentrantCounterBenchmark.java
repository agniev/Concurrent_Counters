package com.jenkov;

import counters.ReentrantCounter;

/**
 * @author Роман Агниев
 * @since 28.11.2018
 */
public class NonFairReentrantCounterBenchmark extends MyBenchmark {

    @Override
    public void prepare() {
        setCounter(new ReentrantCounter(false));
    }
}
