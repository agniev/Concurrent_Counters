import counters.AtomicCounter;

/**
 * @author Роман Агниев
 * @since 28.11.2018
 */
public class AtomicCounterTest extends BaseCounterTest {
    @Override
    void setUpCounter() {
        setCounter(new AtomicCounter());
    }
}
