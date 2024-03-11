public class Static_methods {
    public static int add( int a , int b) {
       return a+b;
    }
    public static int multiply( int a , int b) {
        return a*b;
    }
    public static void main(String[] args) {
        int sumResult = Static_methods.add(3, 5);
        System.out.println("Sum: " + sumResult);

        int productResult =  Static_methods.multiply(4, 6);
        System.out.println("Product: " + productResult);
    }
}
