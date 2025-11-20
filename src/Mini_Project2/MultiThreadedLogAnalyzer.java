package Mini_Project2;

//Mini-Project 2 – Multi-Threaded Log Analyzer
//Objective To design and implement a concurrent system that processes multiple log files simultaneously, applies Stream pipelines for aggregation, and uses thread pools for scalability.
//Requirements
//● Input: Folder path containing text log files.
//● Each file analyzed by a separate worker thread (Callable returning result).
//● Use ExecutorService with fixed pool of N threads.
//● Use ConcurrentHashMap to aggregate keyword counts.
//● Measure total execution time.
//● Output summary to console and write to result file.
//Deliverables
//1. Source code and compiled output.
//2. Execution time comparison between sequential and concurrent versions
//3. Screenshot of thread-pool monitoring (Task Manager or console logs).
//4. README with explanation of concurrency strategy.



import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class MultiThreadedLogAnalyzer {

    // Shared keyword count map (thread-safe)
    private static ConcurrentHashMap<String, Integer> keywordCounts = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter folder path containing log files: ");
        String folderPath = sc.nextLine();
        sc.close();

        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No log files found in folder!");
            return;
        }

        // Fixed thread pool
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        long startTime = System.currentTimeMillis();

        // Submit one task per file
        List<Future<Void>> futures = new ArrayList<>();
        for (File file : files) {
            futures.add(executor.submit(new LogTask(file)));
        }

        // Wait for all tasks to finish
        for (Future<Void> f : futures) {
            try {
                f.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        long endTime = System.currentTimeMillis();

        // Display results
        System.out.println("\n=== LOG ANALYSIS RESULT ===");
        for (Map.Entry<String, Integer> entry : keywordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");

        // Write results to file
        try (PrintWriter out = new PrintWriter("result.txt")) {
            for (Map.Entry<String, Integer> entry : keywordCounts.entrySet()) {
                out.println(entry.getKey() + ": " + entry.getValue());
            }
            out.println("Execution Time: " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nResults saved to result.txt");
    }

    // Worker task for each file
    static class LogTask implements Callable<Void> {
        private File file;

        LogTask(File file) {
            this.file = file;
        }

        @Override
        public Void call() {
            Map<String, Integer> localCount = new HashMap<>();
            localCount.put("ERROR", 0);
            localCount.put("WARN", 0);
            localCount.put("INFO", 0);

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    for (String key : localCount.keySet()) {
                        if (line.contains(key)) {
                            localCount.put(key, localCount.get(key) + 1);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Merge local result into global map
            for (Map.Entry<String, Integer> e : localCount.entrySet()) {
                keywordCounts.merge(e.getKey(), e.getValue(), Integer::sum);
            }

            System.out.println(Thread.currentThread().getName() + " finished " + file.getName());
            return null;
        }
    }
}

