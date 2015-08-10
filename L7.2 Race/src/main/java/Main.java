import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    private static final int HUNDRED_MILLION = 100_000_000;
    private static final int THREADS_NUMBER = 2;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUMBER);

        CallCounter counter = new CallCounter();
        AtomicInteger realCountNumber = new AtomicInteger();

        RaceExample callable01 = new RaceExample(counter, realCountNumber);
        RaceExample callable02 = new RaceExample(counter, realCountNumber);

        long startTime = (new Date()).getTime();

        Future<Integer> future01 = executorService.submit(callable01);
        Future<Integer> future02 = executorService.submit(callable02);

        System.out.println("Future01: " + future01.get());
        System.out.println("Future02: " + future02.get());
        System.out.println("RealCountNumber: " + realCountNumber);

        long finishTime = (new Date()).getTime();
        System.out.println("Time spent: " + (finishTime - startTime));
        executorService.shutdown();
    }

    private static class RaceExample implements Callable<Integer> {
        private final AtomicInteger realCountNumber;
        private final CallCounter counter;

        private RaceExample(CallCounter counter, AtomicInteger realCountNumber) {
            this.realCountNumber = realCountNumber;
            this.counter = counter;
        }

        @Override
        public Integer call() throws Exception {
            while (realCountNumber.incrementAndGet() < HUNDRED_MILLION) {
                counter.increment();
            }
            return counter.getCount();
        }
    }
}
