import java.util.ArrayList;
import java.util.Scanner;
class admin
{
    final static String BLUE = "\033[1;94m";
    final static String GREEN = "\u001b[32;1m";
    final static String YELLOW = "\u001b[33m";
    final static String reset = "\u001b[0m";
    Scanner sc = new Scanner(System.in);
     Food c = new Food();
     ArrayList<Food> stock = c.store();
    String userName = "admin";
    String password = "admin123";
    void adminLogin()
    {
        String un = "";
        String pass = "";
        int x = 0;
        while (!(un.equals(userName) && pass.equals(pass)))
        {
            if(x>0)
            {
                System.out.println("\nINVALID CREDENTIALS");
            }

            System.out.print(BLUE+"ENTER USER NAME : "+reset);
            un = sc.next();
            System.out.print(BLUE+"ENTER PASSWORD : "+reset);
            pass = sc.next();
            x++;
        }
        makeChanges();
    }

    void checkStock(){
        c.display_all(stock);
    }
    void makeChanges(){
        int choice = 0;
        while (choice!=5) {
            System.out.println(GREEN+"\nWHAT WOULD YOU LIKE TO DO ?");
            System.out.println("\n==============================================================================");
            System.out.println("1. SHOW FOOD\n2. EDIT NAME\n3. EDIT PRICE\n4. ADD FOOD \n5. EXIT");
            System.out.println("==============================================================================");
            System.out.print("ENTER CHOICE : "+reset);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    checkStock();
                    break;
                case 2:
                    editName();
                    break;
                case 3:
                    editPrice();
                    break;
                case 4:
                    addFood();
                    break;
                case 5:
                    System.out.println(YELLOW+"\n\nOPERATION COMPLETED SUCCESSFULLY\n\n"+reset);
                    Food_Delivery.main(null);
                    break;
                default:
                    break;
            }
        }
    }

    void addFood()
    {
        Scanner sc = new Scanner(System.in);
        Food f = new Food();
        System.out.print(YELLOW+"ENTER FOOD NAME : "+reset);
        f.dish_name = sc.nextLine();
        System.out.print(YELLOW+"ENTER FOOD PRICE : "+reset);
        f.price = sc.nextInt();
        f.food_id = stock.size()+1;
        stock.add(f);
        stock.get(stock.size()-1).Display();
    }
    void editName()
    {
        System.out.print(BLUE+"ENTER ID OF Food : "+reset);
        int id = sc.nextInt();
        sc.nextLine();
        if(id>stock.size()-1)
        {
            System.out.println("NO FOOD WITH ID " + id);
            return;
        }
        stock.get(id-1).Display();
        System.out.print(BLUE+"ENTER NEW NAME : "+reset);
        stock.get(id-1).dish_name = sc.nextLine();
        stock.get(id-1).Display();
    }
    void editPrice()
    {
        System.out.print(BLUE+"ENTER ID OF FOOD : "+reset);
        int id = sc.nextInt();
        sc.nextLine();
        if(id>stock.size()-1)
        {
            System.out.println("NO FOOD WITH ID " + id);
            return;
        }
        stock.get(id-1).Display();
        System.out.print(BLUE+"ENTER NEW PRICE : "+reset);
        stock.get(id-1).price = sc.nextDouble();
        stock.get(id-1).Display();
    }
}
