import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class C19_9 {

	private static Map<String, byte[]> tagMap;
	private static final Byte[] END = { 0, 1 };
	private List<String> tokens;
	private static int currentTokenIndex;

	public static byte[] encode(char[] input) throws IOException {
		tokenize(input);
		currentTokenIndex = 0;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		encodeTokens(outputStream);
		return outputStream.toByteArray();
	}

	private static void tokenize(char[] input) {
		// TODO Auto-generated method stub

	}

	private static void encodeTokens(ByteArrayOutputStream output)
			throws IOException {
		nextToken("<");

		String tagName = nextToken();
		output.write(getTagCode(tagName));

		while (!hasNextToken(">") && !hasNextTokens("/", ">")) {

			String key = nextToken();
			nextToken("=");
			String value = nextToken();
			output.write(getTagCode(key));
			for (char c : value.toCharArray()) {
				output.write(c);
			}
			output.write(END[0]);
			output.write(END[1]);
		}

		output.write(END[0]);
		output.write(END[1]);

		if (hasNextTokens("/", ">")) {
			nextToken("/");
			nextToken(">");
		} else {
			nextToken(">");

			while (!hasNextTokens("<", "/")) {
				encodeTokens(output); // encode child
			}

			nextToken("<");
			nextToken("/");
			nextToken(tagName);
			nextToken(">");
		}
		output.write(END[0]);
		output.write(END[1]);
	}

	private static boolean hasNextTokens(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean hasNextToken(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	private static byte[] getTagCode(String tagName) {
		return tagMap.get(tagName);
	}

	private static String nextToken(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String nextToken() {
		return null;
	}
}
