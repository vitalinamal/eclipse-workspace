package homework7;

import java.io.*;

public class MultiThreadedFileCopy {
    private static final int BUFFER_SIZE = 1024; // Buffer size for copying blocks
    private static final int NUM_THREADS = 4; // Number of threads for concurrent copying

    public static void main(String[] args) {
        String sourceFilePath = "Homework OOP 4\\src\\files\\prva.csv";
        String destinationFilePath = "Homework OOP 4\\src\\files\\test.csv";

        File sourceFile = new File(sourceFilePath);
        long fileSize = sourceFile.length();

        ProgressTracker tracker = new ProgressTracker(fileSize);
        long bytesPerThread = fileSize / NUM_THREADS;

        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            long start = i * bytesPerThread;
            long end = (i == NUM_THREADS - 1) ? fileSize - 1 : (i + 1) * bytesPerThread - 1;

            FileCopyTask task = new FileCopyTask(sourceFile, destinationFilePath, start, end, tracker);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        boolean completed = false;
        while (!completed) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double progress = (double) tracker.getCopiedBytes() / tracker.getTotalBytes() * 100;
            displayProgressBar(progress);
            completed = tracker.getCopiedBytes() >= tracker.getTotalBytes();
        }

        System.out.println("\nFile copy completed successfully.");
    }

    private static void displayProgressBar(double progress) {
        int barLength = 50;
        int completedBars = (int) (progress / 100 * barLength);
        String progressBar = "\r[";
        for (int i = 0; i < barLength; i++) {
            if (i < completedBars) {
                progressBar += "=";
            } else {
                progressBar += " ";
            }
        }
        progressBar += String.format("] %.2f%%", progress);
        System.out.print(progressBar);
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