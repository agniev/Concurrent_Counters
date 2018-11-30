import counters.ReentrantCounter;

/**
 * @author Роман Агниев
 * @since 29.11.2018
 */
public class ReentrantCounterTest extends BaseCounterTest {
    @Override
    void setUpCounter() {
        setCounter(new ReentrantCounter(false));
    }
}