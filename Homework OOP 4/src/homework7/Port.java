package homework7;

public class Port {
    private static final int NUM_DOCKS = 2;
    private volatile int docksAvailable = NUM_DOCKS;

    public void unloadCargo(ShipUnloading ship) {
        System.out.println("Ship " + ship.getId() + " has arrived at the port.");
        synchronized (this) {
            System.out.println("Available docks before: " + docksAvailable);
            while (docksAvailable == 0) {
                try {
                    System.out.println("Ship " + ship.getId() + " is waiting for a dock.");
                    wait(); // Ship waits until a dock becomes available
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            docksAvailable--;
            System.out.println("Available docks after: " + docksAvailable);
        }

        System.out.println("Ship " + ship.getId() + " is unloading cargo...");
        for (int i = 1; i <= ShipUnloading.NUM_BOXES; i++) {
            try {
                Thread.sleep(500); // Simulate unloading speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ship " + ship.getId() + ": Unloaded box " + i);
        }

        synchronized (this) {
            docksAvailable++;
            System.out.println("Available docks when finished: " + docksAvailable);

            notify(); // Notify other waiting ships that a dock is available
        }

        System.out.println("Ship " + ship.getId() + " has finished unloading.");
    }
}
