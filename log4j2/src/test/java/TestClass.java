import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.stream.IntStream;

public class TestClass {
    @Test
    public void test1() {
        Logger log = LogManager.getLogger("LLL");
        log.debug("deb");
        log.info("inf");
        IntStream.range(1, 20).forEach(i -> log.info("event no " + i));
    }
}
