package homework7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadedFileSearchAdvanced {
    private static final int NUM_THREADS = 4; // Number of threads for concurrent file search

    public static void main(String[] args) {
        String searchFileName = "test.doc";
        String searchDirectory = "Homework OOP 4\\src"; // Replace with the directory to start the search

        List<String> fileAddresses = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        searchFiles(searchFileName, new File(searchDirectory), fileAddresses, executorService);

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (fileAddresses.isEmpty()) {
            System.out.println("File not found in the specified directory.");
        } else {
            System.out.println("Files found with the specified name:");
            for (String address : fileAddresses) {
                System.out.println(address);
            }
        }
    }

    private static void searchFiles(String fileName, File directory, List<String> fileAddresses, ExecutorService executorService) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // Search in the subdirectory using a new thread
                        executorService.execute(() -> searchFiles(fileName, file, fileAddresses, executorService));
                    } else {
                        if (file.getName().equals(fileName)) {
                            fileAddresses.add(file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}

