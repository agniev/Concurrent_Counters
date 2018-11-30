import counters.CasCounter;

/**
 * @author Роман Агниев
 * @since 29.11.2018
 */
public class CasCounterTest extends BaseCounterTest {
    @Override
    void setUpCounter() {
        setCounter(new CasCounter());
    }
}