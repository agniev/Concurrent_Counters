import com.jenkov.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author Роман Агниев
 * @since 28.11.2018
 */
public class Main {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(SynchronizedCounterBenchmark.class.getSimpleName())
                .include(AtomicCounterBenchmark.class.getSimpleName())
                .include(CasCounterBenchmark.class.getSimpleName())
                .include(FairReentrantCounterBenchmark.class.getSimpleName())
                .include(NonFairReentrantCounterBenchmark.class.getSimpleName())
                .build();
        new Runner(options).run();
    }
}
