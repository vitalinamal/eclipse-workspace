package homework7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ShipUnloading {
    private static final int NUM_SHIPS = 3;
    private static final int NUM_BOXES_PER_SHIP = 10;
    private static final int NUM_DOCKS = 2;
    private static final int UNLOAD_SPEED_MILLIS = 500; // 0.5 seconds per box

    private static Semaphore docksSemaphore = new Semaphore(NUM_DOCKS);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_DOCKS);

        for (int shipId = 1; shipId <= NUM_SHIPS; shipId++) {
            executorService.execute(new Ship(shipId));
        }

        executorService.shutdown();
    }

    static class Ship implements Runnable {
        private final int shipId;

        Ship(int shipId) {
            this.shipId = shipId;
        }

        @Override
        public void run() {
            System.out.println("Ship " + shipId + " has arrived at the port.");
            try {
                docksSemaphore.acquire(); // Try to acquire a dock
                unloadCargo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                docksSemaphore.release(); // Release the dock once unloading is done
            }
        }

        private void unloadCargo() throws InterruptedException {
            System.out.println("Ship " + shipId + " is unloading cargo...");
            for (int i = 1; i <= NUM_BOXES_PER_SHIP; i++) {
                Thread.sleep(UNLOAD_SPEED_MILLIS);
                System.out.println("Ship " + shipId + ": Unloaded box " + i);
            }
            System.out.println("Ship " + shipId + " has finished unloading.");
        }
    }
}
