import java.util.Scanner;

class combo
{
    final static String GREEN = "\u001b[32;1m";
    final static String YELLOW = "\u001b[33m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String CYAN = "\033[0;36m";
    final static String reset = "\u001b[0m";

    Scanner sc = new Scanner(System.in);
    void display()
    {
        System.out.println(GREEN+"\n==============================================================================");
//        System.out.println("₹20 off on Order of 150 or Above");
//        System.out.println("₹50 off on Order of 250 or Above");
//        System.out.println("₹100 off on Order of 400 or Above");
        System.out.println("1. Get Crispy Veg Burger + Fries + Coca Cola Combo in just ₹200");
        System.out.println("2. Get Two Margherita Pizzas(Regular) in just ₹300");
        System.out.println("3. McVeggie Burger + McAloo Tikki Burger + Sprite Combo in just ₹300");
//        System.out.println("No Delivery Charge On Order of 400 or Above");
        System.out.println("\n=============================================================================="+reset);
        select();
    }

    void select()
    {
        String temp;
        while (true)
        {
            System.out.print(GREEN + "\nDo You want to Purchase Any Combo (If yes enter 'Y' or no enter 'N') : " + reset);
            temp = sc.nextLine();
            if (temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("N"))
            {
                break;
            }
            else
            {
                System.out.println(RED_BOLD_BRIGHT+"\nINVALID INPUT"+reset);
                continue;
            }
        }

        if (temp.equalsIgnoreCase("Y"))
        {
            System.out.print("Enter Choice of Combo : ");
            int x = sc.nextInt();
            boolean loop = true;
            while (loop)
            {
                switch (x)
                {
                    case 1:
                        System.out.println();
                        System.out.println(YELLOW+"Your Selected Combo is \nItem : Crispy Veg Burger + Fries + Coca Cola \nPrice : 200"+reset);
                        purchase p1 = new purchase();
                        p1.payment();
                        loop = false;
                        break;
                    case 2:
                        System.out.println();
                        System.out.println(YELLOW+"Your Selected Combo is \nItem : Two Margherita Pizzas(Regular) \nPrice : 300"+reset);
                        purchase p2 = new purchase();
                        p2.payment();
                        loop = false;
                        break;
                    case 3:
                        System.out.println();
                        System.out.println(YELLOW+"Your Selected Combo is \nItem : McVeggie Burger + McAloo Tikki Burger + Sprite \nPrice : 300"+reset);
                        purchase p3 = new purchase();
                        p3.payment();
                        loop = false;
                        break;
                    default:
                        System.out.println(RED_BOLD_BRIGHT+"INVALID CHOICE"+reset);

                }
            }
        }

        else
        {
            System.out.println();
        }
    }
}
