public class EcommerceTest {
    public static void main(String[] args) {

        // Sorted by productId (required for binary search)
        Product[] products = {
            new Product(101, "Laptop",     "Electronics"),
            new Product(205, "Shoes",      "Footwear"),
            new Product(310, "Headphones", "Electronics"),
            new Product(415, "T-Shirt",    "Clothing"),
            new Product(520, "Backpack",   "Accessories")
        };

        int searchId = 310;

        // Linear Search
        System.out.println("=== Linear Search ===");
        long start = System.nanoTime();
        Product result1 = SearchAlgorithms.linearSearch(products, searchId);
        long end = System.nanoTime();
        System.out.println("Searching for ID: " + searchId);
        System.out.println("Found: " + result1);
        System.out.println("Time: " + (end - start) + " ns");

        // Binary Search
        System.out.println("\n=== Binary Search ===");
        start = System.nanoTime();
        Product result2 = SearchAlgorithms.binarySearch(products, searchId);
        end = System.nanoTime();
        System.out.println("Searching for ID: " + searchId);
        System.out.println("Found: " + result2);
        System.out.println("Time: " + (end - start) + " ns");

        // Search for non-existing product
        System.out.println("\n=== Search for non-existing ID: 999 ===");
        Product result3 = SearchAlgorithms.linearSearch(products, 999);
        System.out.println("Linear Search Result: " + 
            (result3 == null ? "Product not found" : result3));

        // Complexity Analysis
        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Linear Search: O(n) - checks each element");
        System.out.println("Binary Search: O(log n) - halves search space each time");
        System.out.println("Binary Search is faster for large sorted datasets");
    }
}
