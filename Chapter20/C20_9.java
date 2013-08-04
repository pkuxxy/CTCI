import java.util.Collections;
import java.util.PriorityQueue;

public class C20_9 {
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
			10, Collections.reverseOrder());
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(
			10);

	public static void addNum(int num) {
		if (maxHeap.size() == minHeap.size()) {
			if (minHeap.peek() != null && minHeap.peek() < num) {
				maxHeap.add(minHeap.poll());
				minHeap.add(num);
			} else
				maxHeap.add(num);
		} else {
			if (maxHeap.peek() > num) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			} else
				minHeap.add(num);
		}
	}

	public static double getMedian() {
		if (maxHeap.isEmpty() && minHeap.isEmpty()) {
			System.out.println("Error");
			return Double.MIN_VALUE;
		}
		if (maxHeap.isEmpty())
			return minHeap.peek();
		else if (minHeap.isEmpty())
			return maxHeap.peek();
		if (maxHeap.size() == minHeap.size()) {
			return (minHeap.peek() + maxHeap.peek()) / 2;
		} else if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		} else {
			return minHeap.peek();
		}
	}
}
