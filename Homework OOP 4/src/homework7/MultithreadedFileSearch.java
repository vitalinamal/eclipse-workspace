package homework7;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class MultithreadedFileSearch {
    private static final int NUM_THREADS = 4; // Number of threads for concurrent file search

    public static void main(String[] args) {
        String searchFileName = "test.doc";
        String searchPath = "Homework OOP 4\\src"; // Replace with the directory to start the search

  
        File searchDirectory = new File(searchPath);
        if (!searchDirectory.exists() || !searchDirectory.isDirectory()) {
            System.out.println("Invalid search path.");
            return;
        }

        Set<String> foundFiles = new HashSet<>();
        FileSearchTask rootTask = new FileSearchTask(searchFileName, searchDirectory, foundFiles);
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(rootTask);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("File search completed. Found files:");
        for (String path : foundFiles) {
            System.out.println(path);
        }
    }

    static class FileSearchTask implements Runnable {
        private String searchFileName;
        private File searchDirectory;
        private Set<String> foundFiles;

        public FileSearchTask(String searchFileName, File searchDirectory, Set<String> foundFiles) {
            this.searchFileName = searchFileName;
            this.searchDirectory = searchDirectory;
            this.foundFiles = foundFiles;
        }

        @Override
        public void run() {
            searchFiles(searchDirectory);
        }

        private void searchFiles(File directory) {
            File[] files = directory.listFiles();
            if (files == null) {
                return;
            }

            for (File file : files) {
                if (file.isDirectory()) {
                    FileSearchTask task = new FileSearchTask(searchFileName, file, foundFiles);
                    task.run();
                } else {
                    if (file.getName().equals(searchFileName)) {
                        String absolutePath = file.getAbsolutePath();
                        synchronized (foundFiles) {
                            if (!foundFiles.contains(absolutePath)) {
                                System.out.println("Found: " + absolutePath);
                                foundFiles.add(absolutePath);
                            }
                        }
                    }
                }
            }
        }
    }
}