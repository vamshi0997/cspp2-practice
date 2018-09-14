import java.util.Scanner;
import java.util.ArrayList;
/**
 * item class.
 */
class Item {
    /**
     * product name.
     */
    private String productName;
    /**
     * product quantity.
     */
    private int quantity;
    /**
     * product price.
     */
    private double price;
    /**
     * constructor for quantity, product, price.
     *
     * @param product string.
     * @param quantity1 int.
     * @param price1 double.
     */
    Item(final String product, final int quantity1, final double price1) {
        this.productName = product;
        this.quantity = quantity1;
        this.price = price1;
    }
    /**
     * constructor when product and quantity are given.
     *
     * @param product string
     * @param quantity1 int
     */
    Item(final String product, final int quantity1) {
        this.productName = product;
        this.quantity = quantity1;
    }
    /**
     * method to get productname.
     *
     * @return product
     */
    String getProduct() {
        return this.productName;
    }
    /**
     * method to set productname.
     *
     * @param product1 string.
     */
    void setProduct(final String product1) {
        productName = product1;
    }
    /**
     * method to get quantity.
     *
     * @return quantity
     */
    int getQuantity() {
        return this.quantity;
    }
    /**
     * method to set quantity.
     *
     * @param quantity2 int.
     */
    void setQuantity(final int quantity2) {
        quantity = quantity2;
    }
    /**
     * method to get price.
     *
     * @return price.
     */
    Double getPrice() {
        return this.price;
    }
    /**
     * method to set price.
     *
     * @param price2 price.
     */
    void setPrice(final Double price2) {
        price = price2;
    }
    /**
     * catalog for all items.
     *
     * @return catalog.
     */
    public String scatalog() {
        return productName + " " + quantity + " " + price;
    }
    /**
     * cart for all items.
     *
     * @return cart.
     */
    public String scart() {
        return productName + " " + quantity;
    }
}

/**
 * Shopping cart class contain methods.
 */
class ShoppingCart {
    /**
     * catalog arraylist.
     */
    private ArrayList<Item> catalog = new ArrayList<Item>();
    /**
     * cart arraylist.
     */
    private ArrayList<Item> cart = new ArrayList<Item>();
    /**
     * dicount variable.
     */
    private int discount1 = 0;
    /**
     * add item to catalog.
     *
     * @param item Item.
     */
    public void addToCatalog(final Item item) {
        catalog.add(item);
    }
    /**
     * add item to cart.
     *
     * @param item Item.
     */
    public void addToCart(final Item item) {
        Item temp = null;
        for (Item i : catalog) {
            if (i.getProduct().equals(item.getProduct())) {
                item.setPrice(i.getPrice());
                for (Item j : cart) {
                    if (j.getProduct().equals(item.getProduct())) {
                        j.setQuantity(j.getQuantity() + item.getQuantity());
                        temp = j;
                        break;
                    }
                }
                if (temp == null) {
                    cart.add(item);
                }
                break;
            }
        }

    }
    /**
     * removing item to cart.
     *
     * @param item Item.
     */
    public void removeFromCart(final Item item) {
        for (Item i : cart) {
            if (i.getProduct().equals(item.getProduct())) {
                i.setQuantity(i.getQuantity() - item.getQuantity());
                if (i.getQuantity() == 0) {
                    cart.remove(i);
                }
                break;
            }
        }
    }
    /**
     * show items in cart.
     */
    public void showCart() {
        for (Item i: cart) {
            System.out.println(i.scart());
        }
    }
    /**
     * show items in catalog.
     */
    public void showCatalog() {
        for (Item i: catalog) {
            System.out.println(i.scatalog());
        }
    }
    /**
     * To get total amount.
     *
     * @return amount.
     */
    public double getTotalAmount() {
        double amount = 0;
        for (Item i: cart) {
            for (Item j: catalog) {
                if (i.getProduct().equals(j.getProduct())) {
                    amount = amount + (i.getQuantity() * j.getPrice());
                }
            }
        }
        return amount;
    }
    /**
     * To get payable amount.
     * @return payamble amount
     */
    public double getPayableAmount() {
        return (getTotalAmount() - disc(discount1) + tax());
    }
    /**
     * private hundred.
     */
    private final int hundred = 100;
    /**
     * to get the discount amount.
     *
     * @param discount integer.
     * @return discount
     */
    private double disc(final int discount) {
        double disc1 = 0;
        disc1 = disc1 + (discount1 * getTotalAmount() / hundred);
        return disc1;
    }
    /**
     * to get the tax on the amount.
     *
     * @return tax
     */
    private double tax() {
        final int temp = 15;
        double tax1 = 0;
        tax1 = tax1 + (temp * (getTotalAmount() - disc(discount1)) / hundred);
        return tax1;
    }
    /**
     * applying the coupon.
     *
     * @param discount String
     */
    public void applyCoupon(final String discount) {
        final int ten = 10;
        final int twenty = 20;
        final int thirty = 30;
        final int fifty = 50;
        int discount2 = 0;
        if (discount.equals("IND10")) {
            discount2 = ten;
        } else if (discount.equals("IND20")) {
            discount2 = twenty;
        } else if (discount.equals("IND30")) {
            discount2 = thirty;
        } else if (discount.equals("IND50")) {
            discount2 = fifty;
        } else {
            System.out.println("Invalid coupon");
        }

        if (discount1 < discount2) {
            discount1 = discount2;
        }
    }
    /**
     * printing invoice.
     */
    public void printInvoice() {
        System.out.println("Name   quantity   Price");
        for (Item i: cart) {
            for (Item j: catalog) {
                if (i.getProduct().equals(j.getProduct())) {
                    System.out.println(i.scart() + " " + j.getPrice());
                }
            }
        }
        System.out.println("Total:" + getTotalAmount());
        System.out.println("Disc%:" + disc(discount1));
        System.out.println("Tax:" + tax());
        System.out.println("Payable amount:" + " " + getPayableAmount());

    }
}

/**
 * solution class.
 */
public final class Solution {
    /**
     * @default constructor.
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param args String.
     */
    public static void main(final String[] args) {
        ShoppingCart shop = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "Item":
                Item item = new Item(check[1], Integer.parseInt(
                    tokens[1]), Double.parseDouble(tokens[2]));
                shop.addToCatalog(item);
                break;
                case "add":
                Item item1 = new Item(check[1], Integer.parseInt(
                    tokens[1]));
                shop.addToCart(item1);
                break;
                case "remove":
                Item item2 = new Item(check[1], Integer.parseInt(
                    tokens[1]));
                shop.removeFromCart(item2);
                break;
                case "totalAmount":
                System.out.println(
                    "totalAmount:" + " " + shop.getTotalAmount());
                break;
                case "payableAmount":
                System.out.println(
                    "Payable amount:" + " " + shop.getPayableAmount());
                break;
                case "print":
                shop.printInvoice();
                break;
                case "catalog":
                shop.showCatalog();
                break;
                case "show":
                shop.showCart();
                break;
                case "coupon":
                shop.applyCoupon(check[1]);
                break;
                default:
                break;

            }
        }
    }
}
