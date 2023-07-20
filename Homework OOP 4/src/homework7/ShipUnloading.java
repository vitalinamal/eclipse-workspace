package homework7;

public class ShipUnloading implements Runnable {
    public static final int NUM_BOXES = 10;
    private final int id;
    private final Port port;

    public ShipUnloading(int id, Port port) {
        this.id = id;
        this.port = port;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        port.unloadCargo(this);
    }

    public static void main(String[] args) {
        Port port = new Port();
        for (int i = 1; i <= 3; i++) {
            new Thread(new ShipUnloading(i, port)).start();
        }
    }
}