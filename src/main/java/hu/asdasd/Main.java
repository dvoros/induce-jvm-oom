package hu.asdasd;

public class Main {
    public static void main(String[] args) throws Exception {
        Main memoryTest = new Main();
        memoryTest.generateOOM();
    }

    // From: https://makeinjava.com/simulate-generate-memory-error-java-example/
    public void generateOOM() throws Exception {
        int dummyArraySize = 15;
        System.out.println("Max JVM memory: " + Runtime.getRuntime().maxMemory());
        System.out.println("Total JVM memory: " + Runtime.getRuntime().totalMemory());
        System.out.println("Free JVM memory: " + Runtime.getRuntime().freeMemory());
        long memoryConsumed = 0;
        long[] memoryAllocated = null;
        for (int loop = 0; loop < Integer.MAX_VALUE; loop++) {
            memoryAllocated = new long[dummyArraySize];
            memoryAllocated[0] = 0;
            memoryConsumed += dummyArraySize * Long.SIZE;
            System.out.println("Memory Consumed till now: " + memoryConsumed);
            dummyArraySize *= dummyArraySize * 2;
            Thread.sleep(500);
        }
    }

}