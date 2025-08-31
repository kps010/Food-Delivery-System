import javax.swing.JOptionPane;
import java.util.*;

class Food_Delivery
{
    final static String GREEN = "\u001b[32;1m";
    final static String YELLOW = "\u001b[33m";
    final static String BLUE = "\033[1;94m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String CYAN = "\033[0;36m";
    final static String reset = "\u001b[0m";
    static ArrayList<customer> userData = new ArrayList<>();
    public static void main(String[] args)
    {
        customer c = new customer("kunal12", "Kunal Prajapati", "12345", "9839743210");
        userData.add(c);

        int startingChoice = 0;
        while (true)
        {
            startingChoice = starting();
            if(startingChoice==1 || startingChoice==2)
            {
                break;
            }
            else
            {
                System.out.println(RED_BOLD_BRIGHT+"INVALID CHOICE"+reset);
                startingChoice = starting();
            }
        }
        System.out.println();
        if(startingChoice==1)
        {
            admin a = new admin();
            a.adminLogin();
        }
        else
        {
            int intial_choice = 0;
            while (true) {
                intial_choice = homePage();
                if (intial_choice == 1 || intial_choice == 2) {
                    break;
                } else {
                    intial_choice = homePage();
                }
            }
            System.out.println();
            switch (intial_choice)
            {
                case 1:
                    register();
                    login();
                    menu();
                    break;
                case 2:
                    login();
                    menu();
                    break;
                default:
                    System.out.println(RED_BOLD_BRIGHT+"INVALID CHOICE"+reset);
            }

            String review = JOptionPane.showInputDialog(null,"ENTER REVIEW ","enter here");
            System.out.println(CYAN+"THANK YOU FOR CHOOSING OUR SYSTEM"+reset);
            System.out.println(CYAN + "VISIT AGAIN!" + reset);
        }
    }

    public static int starting()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(BLUE+"\n===================================WELCOME===================================");
        System.out.println("1. ADMIN\n2. CUSTOMER");
        System.out.println("==============================================================================");
        System.out.print("\nENTER YOUR CHOICE : "+reset);
        int intial_choice = sc.nextInt();

        return intial_choice;
    }
    // homepage method
    static int homePage()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(BLUE+"\n===================================WELCOME====================================");
        System.out.println("1. REGISTER\n2. LOGIN");
        System.out.println("==============================================================================");
        System.out.print("\nENTER YOUR CHOICE : "+reset);
        int intial_choice = sc.nextInt();

        return intial_choice;
    }

    //  REGISTER METHOD
    static void register()
    {
        boolean check = true;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        String mno = "";

        while (true)
        {
            System.out.print("Enter Mobile Number: ");
            mno = sc.next();
            if(mno.length()!=10)
            {
                System.out.println(RED_BOLD_BRIGHT+"INVALID LENGTH"+reset);
            }
            else if(mno.length()==10)
            {
                for(int i=0 ; i<10 ; i++)
                {
                    if(mno.charAt(i)<='9' && mno.charAt(i)>='0')
                    {
                        continue;
                    }
                    else
                    {
                        check = false;
                        break;
                    }
                }
                if(!check)
                {
                    System.out.println(RED_BOLD_BRIGHT+"INVALID"+reset);
                }
                else
                {
                    break;
                }
            }
        }
        verifyMobileNo(mno,name);
    }

    //MOBILE NO. VERIFICATION METHOD
    static void verifyMobileNo(String mno,String name)
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int otp = 1000+random.nextInt(10000);
        do
        {
            JOptionPane.showMessageDialog(null, "YOUR OTP IS : "+otp, "VERIFT", JOptionPane.PLAIN_MESSAGE);
            String enteredOtp = JOptionPane.showInputDialog(null,"ENTER OTP ","enter here");
            if(otp == Integer.parseInt(enteredOtp))
            {
                JOptionPane.showMessageDialog(null, "MOBILE NUMBER VERIFIED!","SUCCESSFUL",JOptionPane.PLAIN_MESSAGE);

                System.out.print("Enter Password: ");
                String pass = sc.next();

                String[] arr = name.split(" ");
                String userId = arr[0] + mno.charAt(1) + mno.charAt(2) + mno.charAt(3);

                System.out.println("\nYOUR USER ID: " + userId);
                System.out.println("YOUR PASSWORD: " + pass + "\n");

                customer c = new customer(userId, name, pass, mno);
                userData.add(c);
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "WRONG OTP", "INVALID", JOptionPane.ERROR_MESSAGE);
            }
        }while (true);
    }

    //  LOGIN METHOD
    static void login()
    {
        Scanner sc = new Scanner(System.in);
        String id;
        String pass;

        boolean log = false;
        int z=0;
        while (!log)
        {
            if(z>0)
            {
                System.out.println(RED_BOLD_BRIGHT+"\nINAVLID USER ID OR PASSWORD !!\n"+reset);
            }
            System.out.print("Enter User ID: ");
            id = sc.next();
            System.out.print("Enter password: ");
            pass = sc.next();

            for(int i=0 ; i<userData.size() ; i++)
            {
                if(!(id.equals(userData.get(i).id) && pass.equals(userData.get(i).password)))
                {
                    continue;
                }
                else
                {
                    //index=i;
                    log = true;
                    break;
                }
            }
            z++;
        }

    }

    //MENU METHOD
    static void menu()
    {
        Scanner sc = new Scanner(System.in);
        Food food = new Food();
        ArrayList<Food> Stock = food.store();
        int c = 0;
        while (c!=5)
        {
            System.out.println(GREEN+"\n==============================================================================");
            System.out.println("1. SEARCH FOOD ITEM\n2. SHOW FOOD ITEMS\n3. PURCHASE\n4. SHOW COMBOS\n5. EXIT");
            System.out.println("==============================================================================");
            System.out.print("\nENTER YOUR CHOICE : "+reset);
            c = sc.nextInt();
            System.out.println();
            switch (c)
            {
                case 1:
                    search();
                    break;
                case 2:
                    food.display_all(Stock);
                    break;
                case 3:
                    purchase p = new purchase();
                    p.purchase_food(Stock);
                    //c = 4;
                    break;
                case 4:
                    combo co = new combo();
                    co.display();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    //  SEARCH METHOD
    static void search()
    {
        Food food = new Food();
        ArrayList<Food> Stock = food.store();
        Scanner sc = new Scanner(System.in);
        System.out.println(YELLOW+"\n==============================================================================");
        System.out.println("1. SEARCH BY NAME\n2. SEARCH BY COMPANY\n3. SEARCH BY PRICE");
        System.out.println("==============================================================================");
        System.out.print("\nENTER YOUR CHOICE : "+reset);
        int s = sc.nextInt();
        switch (s)
        {
            case 1:
                food.search_by_name(Stock);
                break;
            case 2:
                food.search_by_restaurant(Stock);
                break;
            case 3:
                food.search_by_price(Stock);
                break;
            default:
                System.out.println(RED_BOLD_BRIGHT+"INVALID INPUT"+reset);
                break;
        }
    }
}