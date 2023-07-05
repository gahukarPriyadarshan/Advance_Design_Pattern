// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class singletonMain {
    public static void main(String[] args) {
        SingleObject try1= SingleObject.getInstance();
        SingleObject try2= SingleObject.getInstance();
        SingleObject try3= SingleObject.getInstance();

        System.out.println("Hashcode of try1 is "
                + try1.hashCode());
        System.out.println("Hashcode of try2 is "
                + try2.hashCode());
        System.out.println("Hashcode of try3 is "
                + try3.hashCode());

        // Condition check
        if (try1 == try2 && try2 == try3) {

            // Print statement
            System.out.println(
                    "showMessage called by try1");
            try1.showMessage();
            System.out.println(
                    "showMessage called by try2");
            try2.showMessage();
            System.out.println(
                    "showMessage called by try3");
            try3.showMessage();

        }

        else {
            // Print statement
            System.out.println(
                    "Three objects DO NOT point to the same memory location on the heap");
        }
    }
}