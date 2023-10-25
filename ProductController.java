import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductController {

    private Scanner scanner = new Scanner(System.in);
    private ProductGateway productGateway = new ProductGateway();

    public void createProducts()
    {
        System.out.println("ENTER NAME , PRICE , CATEGORY AND QUANTITY RESPECTIVELY");
        String name = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.nextLine();
        String category = scanner.nextLine();
        int quantity = scanner.nextInt();

        Product product = new Product(name ,price , category , quantity);
        boolean status = productGateway.insert(product);
        if(status==true){
            System.out.println("Product Inserted Successfully");
        }else
        {
            System.out.println("Some Problem, Check And Try Again");
        }
    }
    public  void deleteProducts()
    {
        ArrayList<Product> products = productGateway.index();
        this.displayProducts(products);
        System.out.println("CHOOSE AN OPTION");
        int idx = scanner.nextInt();
        Product product = products.get(idx-1);
        boolean status = productGateway.delete(product.getId());
        if(status==true)
        {
            System.out.println("Product Deleted Successfully");
        }
        else
        {
            System.out.println("Some Problem, Check And Try Again");
        }
    }
    public  void updateProducts()
    {
        ArrayList<Product> products = productGateway.index();
        this.displayProducts(products);
        System.out.println("CHOOSE A PRODUCT TO UPDATE");
        int idx = scanner.nextInt();
        Product product = products.get(idx-1);
        System.out.println(product.getName()+" "+ product.getPrice()+" "+ product.getCategory());
        int option;
        do{
        System.out.println("1 - NAME");
        System.out.println("2 - PRICE");
        System.out.println("3 - CATEGORY");
        System.out.println("4 - QUANTITY");
        System.out.println("CHOOSE A COLUMN TO UPDATE");
        int column = scanner.nextInt();
        scanner.nextLine();
        switch (column)
        {
            case 1:
            {
                System.out.println("ENTER NEW NAME");
                String newname  = scanner.nextLine();
                product.setName(newname);
                break;
            }
            case 2:
            {
                System.out.println("ENTER NEW PRICE");
                int newprice  = scanner.nextInt();
                product.setPrice(newprice);
                break;

            }
            case 3:
            {
                System.out.println("ENTER NEW CATEGORY");
                String newcategory  = scanner.nextLine();
                product.setName(newcategory);
                break;

            }
            case 4:
            {
                System.out.println("ENTER NEW QUANTITY");
                int newquantity= scanner.nextInt();
                product.setQuantity(newquantity);
                break;

            }

        }
        System.out.println(product.getName()+" "+product.getPrice()+" "+product.getCategory()+" "+product.getQuantity());
        System.out.println("1- CONTINUE FOR UPDATING ,2- DONE UPDATE  ");
        option=scanner.nextInt();
    }
        while (option==1);


    boolean status= productGateway.update(product);


        if(status==true)
    {
        System.out.println("Product Updated");
    }
        else
    {
        System.out.println("Some Problem");
    }
}

    public  void getAllProducts()
    {
        ArrayList<Product> products = productGateway.index();
        this.displayProducts(products);
    }
            public void displayProducts(ArrayList<Product> products)
            {
                int SerialNumber =1;
                for(Product product:products)
                {
                    System.out.println(SerialNumber+" "+product.getName()+" "+ product.getPrice()+" "+ product.getCategory());
                    SerialNumber ++;
                }

            }
     public void getProductsByCategory(){
        ArrayList<Product> products = productGateway.byCategoy();

     }

}
