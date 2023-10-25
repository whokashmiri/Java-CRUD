import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
ProductController productController = new ProductController();
        Scanner scanner = new Scanner(System.in);
        int forContinue;
        do {

            System.out.println("SELECT AN OPTION");
        System.out.println("1- CREATE");
        System.out.println("2- DELETE");
        System.out.println("3- DISPLAY");
        System.out.println("4- UPDATE");
        int choose = scanner.nextInt();
        switch (choose)
        {
            case 1: {
                productController.createProducts();
                break;
            }
            case 2: {
                productController.deleteProducts();

                break;
            }
            case 3: {
                productController.getAllProducts();

            }
            case 4: {
                productController.updateProducts();
                break;
            }
        }
            System.out.println("DO YOU WANT CONTINUE PRESS 1 ANYTHING ELSE FOR NOT");
            forContinue =scanner.nextInt();
        }while (forContinue==1);

    }
}