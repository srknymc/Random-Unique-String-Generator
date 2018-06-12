import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class RandomString {
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = upper.toLowerCase(Locale.ROOT);
    public static final String digits = "0123456789";
    public static final String alphanum = upper + lower + digits;
    private final Random random;
    private final char[] symbols;
    private final char[] buffer;
    public RandomString(int length, Random random, String symbols) {
        this.random = Objects.requireNonNull(random,"Random must not be null");
        this.symbols = symbols.toCharArray();
        this.buffer = new char[length];
    }
    public RandomString(int length,String symbols)
    {
    	this(length,new SecureRandom(),symbols);
    }
    public RandomString(int length) {
        this(length, new SecureRandom(),alphanum);
    }
    public String nextString() {
        for (int i = 0; i< buffer.length; i++)
            buffer[i] = symbols[random.nextInt(symbols.length)];
        return new String(buffer);
    }

}
