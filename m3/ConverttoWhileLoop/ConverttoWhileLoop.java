/**
 * @author vamshi
 */
public final class ConverttoWhileLoop {
    /**
     * @details default constructor
     */
    private ConverttoWhileLoop() {

    }
    /**
     * @brief into main function.
     * @param args String
     */
    public static void main(final String[] args) {
        int i = 2;
        while (i <= 10) {
            System.out.println(i);
            i = i + 2;
        }
        System.out.println("GoodBye!");
    }
}
