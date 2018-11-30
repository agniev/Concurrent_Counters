package com.jenkov;

import counters.CasCounter;

/**
 * @author Роман Агниев
 * @since 28.11.2018
 */
public class CasCounterBenchmark extends MyBenchmark {

    @Override
    public void prepare() {
        setCounter(new CasCounter());
    }
}
