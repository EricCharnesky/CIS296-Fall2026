import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

// umgpt - write a multithreaded java merge sort function
public final class ParallelMergeSort {
    private static final int THRESHOLD = 8_192;

    private ParallelMergeSort() {}

    public static void sort(int[] array) {
        Objects.requireNonNull(array, "array");

        if (array.length < 2) {
            return;
        }

        int[] buffer = new int[array.length];
        ForkJoinPool.commonPool().invoke(
                new SortTask(array, buffer, 0, array.length)
        );
    }

    private static final class SortTask extends RecursiveAction {
        private final int[] array;
        private final int[] buffer;
        private final int start;
        private final int end; // Exclusive

        SortTask(int[] array, int[] buffer, int start, int end) {
            this.array = array;
            this.buffer = buffer;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                Arrays.sort(array, start, end);
                return;
            }

            int middle = start + (end - start) / 2;

            // Sort independent halves in parallel, then wait for both.
            invokeAll(
                    new SortTask(array, buffer, start, middle),
                    new SortTask(array, buffer, middle, end)
            );

            // Skip merging if the halves are already ordered.
            if (array[middle - 1] <= array[middle]) {
                return;
            }

            merge(array, buffer, start, middle, end);
        }
    }

    private static void merge(
            int[] array, int[] buffer, int start, int middle, int end
    ) {
        int left = start;
        int right = middle;
        int destination = start;

        while (left < middle && right < end) {
            if (array[left] <= array[right]) {
                buffer[destination++] = array[left++];
            } else {
                buffer[destination++] = array[right++];
            }
        }

        while (left < middle) {
            buffer[destination++] = array[left++];
        }

        while (right < end) {
            buffer[destination++] = array[right++];
        }

        System.arraycopy(buffer, start, array, start, end - start);
    }

    public static void main(String[] args) {

        Random random = new Random(1000);
        int[] values = new int[100000];
        for ( int index=  0; index < values.length; index++){
            values[index] = random.nextInt(1000000);
        }

        //https://stackoverflow.com/questions/3382954/measure-execution-time-for-a-java-method
        long startTime = System.nanoTime();


        //Arrays.sort(values);
        ParallelMergeSort.sort(values);
        long stopTime = System.nanoTime();


        System.out.println(Arrays.toString(values));

        System.out.println(stopTime - startTime);
    }
}