class Swap {

    public static void main(String[] args) {
    	int a = 2, b = 3, temp;
    	System.out.println("a intially:" + a);
	    System.out.println("b initially:" + b);
        temp = a;
        a = b;
        b = temp;
	    System.out.println("a finally:" + a);
	    System.out.println("b finally:" + b);
}
}