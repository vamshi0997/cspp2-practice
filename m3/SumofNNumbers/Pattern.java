/**
 * @author vamshi
 */
public final class Pattern {
    /**
     * @details default constructor
     */
    private Pattern() {

    }
    /**
     * @brief into main function.
     * @param args String
     */
    public static void main(final String[] args) {
        for (int i = 1; i <= 5; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
        System.out.println();
        }
    }
}
