/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jenkov;

import counters.Counter;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.jenkov.MyBenchmark.*;

@State(Scope.Benchmark)
@Warmup(iterations = NUMBER_OF_WARM_UP_ITERATIONS)
@Measurement(iterations = NUMBER_OF_MEASUREMENT_ITERATIONS)
@Fork(NUMBER_OF_FORKS)
@BenchmarkMode({Mode.Throughput, Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public abstract class MyBenchmark {
    static final int NUMBER_OF_MEASUREMENT_ITERATIONS = 5;
    static final int NUMBER_OF_WARM_UP_ITERATIONS = 2;
    static final int NUMBER_OF_FORKS = 1;

    private static final int NUMBER_OF_CYCLES = 1_000_000;

    private Counter counter;

    @Setup
    public abstract void prepare();

    private void testMethod() {
        for (int i = 0; i < NUMBER_OF_CYCLES; i++) {
            counter.incrementAndGet();
        }
    }

    @Benchmark
    @Threads(1)
    public void testCounter_1() {
        testMethod();
    }


    @Benchmark
    @Threads(2)
    public void testCounter_2() {
        testMethod();
    }

    @Benchmark
    @Threads(4)
    public void testCounter_4() {
        testMethod();
    }

    @Benchmark
    @Threads(8)
    public void testCounter_8() {
        testMethod();
    }

    @Benchmark
    @Threads(16)
    public void testCounter_16() {
        testMethod();
    }

    void setCounter(Counter counter) {
        this.counter = counter;
    }
}