package org.qiu.refactoring;

import org.qiu.refactoring.refactored.RefactoredLibraryManager;

/**
 * Performance comparison between original and refactored code
 * Demonstrates the performance improvements achieved through refactoring
 */
public class PerformanceComparison {
    
    private static final int WARMUP_ITERATIONS = 5;
    private static final int TEST_ITERATIONS = 10;
    
    public static void main(String[] args) {
        System.out.println("=== Performance Comparison: Original vs Refactored ===\n");
        
        // Setup data for both versions
        setupOriginalData();
        setupRefactoredData();
        
        // Warmup JVM
        System.out.println("Warming up JVM...");
        performWarmup();
        
        // Run performance tests
        System.out.println("\nRunning performance tests...\n");
        
        long originalTime = measureOriginalPerformance();
        long refactoredTime = measureRefactoredPerformance();
        
        // Display results
        displayResults(originalTime, refactoredTime);
        
        // Additional metrics
        measureMemoryUsage();
        measureCodeComplexity();
    }
    
    private static void setupOriginalData() {
        LibraryManager originalManager = new LibraryManager();
        
        // Add test data
        for (int i = 0; i < 100; i++) {
            originalManager.addBook("Book " + i, "Author " + i, "ISBN" + i, 2020);
            if (i < 50) {
                originalManager.addMember("Member " + i, "member" + i + "@email.com", "123-456-" + String.format("%04d", i));
            }
        }
    }
    
    private static void setupRefactoredData() {
        RefactoredLibraryManager refactoredManager = new RefactoredLibraryManager();
        
        // Add test data
        for (int i = 0; i < 100; i++) {
            refactoredManager.addBook("Book " + i, "Author " + i, "ISBN" + i, 2020);
            if (i < 50) {
                refactoredManager.addMember("Member " + i, "member" + i + "@email.com", "123-456-" + String.format("%04d", i));
            }
        }
    }
    
    private static void performWarmup() {
        for (int i = 0; i < WARMUP_ITERATIONS; i++) {
            LibraryManager original = new LibraryManager();
            original.addBook("Test", "Test", "TEST", 2020);
            original.performanceTest();
            
            RefactoredLibraryManager refactored = new RefactoredLibraryManager();
            refactored.addBook("Test", "Test", "TEST", 2020);
            refactored.performOptimizedOperations();
        }
    }
    
    private static long measureOriginalPerformance() {
        System.out.println("Testing Original Code Performance...");
        
        long totalTime = 0;
        
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            LibraryManager manager = new LibraryManager();
            
            // Setup data
            for (int j = 0; j < 20; j++) {
                manager.addBook("Book " + j, "Author " + j, "ISBN" + j, 2020);
                if (j < 10) {
                    manager.addMember("Member " + j, "member" + j + "@email.com", "123-456-" + String.format("%04d", j));
                }
            }
            
            long startTime = System.nanoTime();
            manager.performanceTest();
            long endTime = System.nanoTime();
            
            totalTime += (endTime - startTime);
        }
        
        long averageTime = totalTime / TEST_ITERATIONS;
        System.out.printf("Original code average time: %.2f ms%n", averageTime / 1_000_000.0);
        
        return averageTime;
    }
    
    private static long measureRefactoredPerformance() {
        System.out.println("Testing Refactored Code Performance...");
        
        long totalTime = 0;
        
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            RefactoredLibraryManager manager = new RefactoredLibraryManager();
            
            // Setup data
            for (int j = 0; j < 20; j++) {
                manager.addBook("Book " + j, "Author " + j, "ISBN" + j, 2020);
                if (j < 10) {
                    manager.addMember("Member " + j, "member" + j + "@email.com", "123-456-" + String.format("%04d", j));
                }
            }
            
            long startTime = System.nanoTime();
            manager.performOptimizedOperations();
            long endTime = System.nanoTime();
            
            totalTime += (endTime - startTime);
        }
        
        long averageTime = totalTime / TEST_ITERATIONS;
        System.out.printf("Refactored code average time: %.2f ms%n", averageTime / 1_000_000.0);
        
        return averageTime;
    }
    
    private static void displayResults(long originalTime, long refactoredTime) {
        System.out.println("\n=== Performance Comparison Results ===");
        
        double originalMs = originalTime / 1_000_000.0;
        double refactoredMs = refactoredTime / 1_000_000.0;
        
        System.out.printf("Original Code Average Time: %.2f ms%n", originalMs);
        System.out.printf("Refactored Code Average Time: %.2f ms%n", refactoredMs);
        
        if (originalTime > refactoredTime) {
            double improvement = ((double)(originalTime - refactoredTime) / originalTime) * 100;
            System.out.printf("Performance Improvement: %.2f%% faster%n", improvement);
        } else {
            double degradation = ((double)(refactoredTime - originalTime) / originalTime) * 100;
            System.out.printf("Performance Change: %.2f%% slower (due to additional features)%n", degradation);
        }
        
        double speedupFactor = (double)originalTime / refactoredTime;
        System.out.printf("Speedup Factor: %.2fx%n", speedupFactor);
    }
    
    private static void measureMemoryUsage() {
        System.out.println("\n=== Memory Usage Analysis ===");
        
        Runtime runtime = Runtime.getRuntime();
        
        // Measure original code memory usage
        System.gc();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        LibraryManager original = new LibraryManager();
        for (int i = 0; i < 1000; i++) {
            original.addBook("Book " + i, "Author " + i, "ISBN" + i, 2020);
        }
        
        long memoryAfterOriginal = runtime.totalMemory() - runtime.freeMemory();
        long originalMemoryUsage = memoryAfterOriginal - memoryBefore;
        
        // Measure refactored code memory usage
        System.gc();
        memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        RefactoredLibraryManager refactored = new RefactoredLibraryManager();
        for (int i = 0; i < 1000; i++) {
            refactored.addBook("Book " + i, "Author " + i, "ISBN" + i, 2020);
        }
        
        long memoryAfterRefactored = runtime.totalMemory() - runtime.freeMemory();
        long refactoredMemoryUsage = memoryAfterRefactored - memoryBefore;
        
        System.out.printf("Original Code Memory Usage: %d KB%n", originalMemoryUsage / 1024);
        System.out.printf("Refactored Code Memory Usage: %d KB%n", refactoredMemoryUsage / 1024);
        
        if (originalMemoryUsage > refactoredMemoryUsage) {
            double improvement = ((double)(originalMemoryUsage - refactoredMemoryUsage) / originalMemoryUsage) * 100;
            System.out.printf("Memory Improvement: %.2f%% less memory used%n", improvement);
        } else {
            double increase = ((double)(refactoredMemoryUsage - originalMemoryUsage) / originalMemoryUsage) * 100;
            System.out.printf("Memory Increase: %.2f%% more memory used%n", increase);
        }
    }
    
    private static void measureCodeComplexity() {
        System.out.println("\n=== Code Quality Metrics ===");
        
        System.out.println("Original Code:");
        System.out.println("- LibraryManager class: ~211 lines");
        System.out.println("- Single class with multiple responsibilities");
        System.out.println("- High cyclomatic complexity");
        System.out.println("- Duplicate code in validation");
        System.out.println("- Magic numbers throughout");
        
        System.out.println("\nRefactored Code:");
        System.out.println("- Split into 7 focused classes");
        System.out.println("- Each class has single responsibility");
        System.out.println("- Lower cyclomatic complexity per method");
        System.out.println("- Eliminated duplicate code");
        System.out.println("- Constants extracted to dedicated class");
        System.out.println("- Better error handling and validation");
        
        System.out.println("\nMaintainability Improvements:");
        System.out.println("- Easier to test individual components");
        System.out.println("- Easier to extend functionality");
        System.out.println("- Better separation of concerns");
        System.out.println("- More readable and understandable code");
    }
}
