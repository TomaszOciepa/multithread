package example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> numbers());
        executorService.submit(() -> numbers());
        executorService.submit(() -> numbers());
        executorService.shutdown(); // zamyka wątek po zakończeniu wszystkich procesów
        //executorService.shutdownNow(); // próbuje, stara się zamknąć wątek w trakcie jego trwania

    }

    private static void numbers() {
        for (int i = 0; i < 999; i++) {
                System.out.println(Thread.currentThread().getName() + " "+ i);
            }
    }

}
