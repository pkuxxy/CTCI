public class C5_1 {
	public static int bitSubString(int n, int m, int i, int j) {
		int mask = 0xffffffff << (j + 1);
		mask = mask | ((1 << i) - 1);
		return ((n & mask) | (m << i));
	}

	public static void main(String[] args) {
		int n = 0x00000400; // 100 0000 0000
		int m = 0x00000015; // 10101
		System.out.println(Integer.toBinaryString(bitSubString(n, m, 2, 6))); // 100 0101 0100
	}
}
