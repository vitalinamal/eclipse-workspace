package homework7;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedFileCopyAdvanced {
    private static final int BUFFER_SIZE = 1024; // Buffer size for copying blocks
    private static final int NUM_THREADS = 4; // Number of threads for concurrent copying

    public static void main(String[] args) {
        String sourceFilePath = "Homework OOP 4\\src\\files\\prva.csv";
        String destinationFilePath = "Homework OOP 4\\src\\files\\test.csv";

        try {
            File sourceFile = new File(sourceFilePath);
            long fileSize = sourceFile.length();

            ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

            ProgressTracker tracker = new ProgressTracker(fileSize);

            for (int i = 0; i < NUM_THREADS; i++) {
                long start = i * (fileSize / NUM_THREADS);
                long end = (i == NUM_THREADS - 1) ? fileSize - 1 : (i + 1) * (fileSize / NUM_THREADS) - 1;

                FileCopyTask task = new FileCopyTask(sourceFile, destinationFilePath, start, end, tracker);
                executorService.execute(task);
            }

            executorService.shutdown();

            while (!executorService.isTerminated()) {
                double progress = (double) tracker.getCopiedBytes() / tracker.getTotalBytes() * 100;
                System.out.printf("Progress: %.2f%%\r", progress);
                Thread.sleep(100);
            }

            System.out.println("\nFile copy completed successfully.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ProgressTracker {
        private volatile long copiedBytes;
        private long totalBytes;

        public ProgressTracker(long totalBytes) {
            this.totalBytes = totalBytes;
        }

        public synchronized void updateCopiedBytes(long bytes) {
            copiedBytes += bytes;
        }

        public synchronized long getCopiedBytes() {
            return copiedBytes;
        }

        public long getTotalBytes() {
            return totalBytes;
        }
    }

    static class FileCopyTask implements Runnable {
        private File sourceFile;
        private String destinationFilePath;
        private long start;
        private long end;
        private ProgressTracker tracker;

        public FileCopyTask(File sourceFile, String destinationFilePath, long start, long end,
                ProgressTracker tracker) {
            this.sourceFile = sourceFile;
            this.destinationFilePath = destinationFilePath;
            this.start = start;
            this.end = end;
            this.tracker = tracker;
        }

        @Override
        public void run() {
            try (RandomAccessFile source = new RandomAccessFile(sourceFile, "r");
                    RandomAccessFile destination = new RandomAccessFile(destinationFilePath, "rw")) {

                source.seek(start);
                destination.seek(start);

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;
                long totalBytesToCopy = end - start + 1;

                while ((bytesRead = source.read(buffer)) != -1 && totalBytesToCopy > 0) {
                    int bytesToWrite = (int) Math.min(totalBytesToCopy, bytesRead);
                    destination.write(buffer, 0, bytesToWrite);
                    tracker.updateCopiedBytes(bytesToWrite);
                    totalBytesToCopy -= bytesToWrite;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}