import javax.swing.JOptionPane;
import java.util.Random;
import java.util.*;

class purchase
{
    final static String GREEN = "\u001b[32;1m";
    final static String YELLOW = "\u001b[33m";
    final static String CYAN = "\u001b[36m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    final static String reset = "\u001b[0m";
    Scanner sc = new Scanner(System.in);

    void purchase_food(ArrayList<Food> f)
    {
        System.out.println(YELLOW + "================================== Welcome ===================================\n"+reset);
        Cart(f);
    }

    double finalprice = 20;
    void Cart(ArrayList<Food> f)
    {
        boolean flag = true;
        ArrayList<Food> cart = new ArrayList<>();
        while (flag)
        {
            System.out.print(YELLOW+"Enter Food ID to Add the Food in Your Cart : " + reset);
            int selected_food = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < f.size(); i++)
            {
                if (selected_food == f.get(i).food_id)
                {
                    flag = false;
                    System.out.println();
                    System.out.println(YELLOW + "Your Selected Food  : ");
                    f.get(i).Display();
                    System.out.println(reset);
                    String temp;
                    String temp1;
                    while (true)
                    {
                        System.out.print(GREEN + "\nDo you want to Add this Food Item in Your Cart (If yes enter 'Y' or no enter 'N') : " + reset);
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
                        System.out.println(GREEN+"Item Added To Your Cart Sucessfully.");
                        finalprice += f.get(i).price;
                        cart.add(f.get(i));
                        //payment();
                        while (true)
                        {
                            System.out.println();
                            System.out.print("Want To Add Another Food To Your Cart (If yes enter 'Y' or no enter 'N') : "+reset);
                            temp1 = sc.nextLine();
                            if (temp1.equalsIgnoreCase("Y") || temp1.equalsIgnoreCase("N"))
                            {
                                break;
                            }
                            else
                            {
                                System.out.println(RED_BOLD_BRIGHT+"\nINVALID INPUT"+reset);
                                continue;
                            }
                        }

                        if (temp1.equalsIgnoreCase("Y"))
                        {
                            Cart(f);
                        }

                        else if(temp1.equalsIgnoreCase("N"))
                        {
                            System.out.println();
                            System.out.println(GREEN+"You Total Bill Amount is : "+finalprice);
                            System.out.println(reset);
                            payment();
                        }
                    }

                    else
                    {
                        if (finalprice>20)
                        {
                            payment();
                        }
                        flag = false;
                    }

                }
            }
        }
    }
    void payment()
    {
        System.out.println();
        System.out.print("Enter Your Address : ");
        sc.nextLine();
        System.out.println(YELLOW + "\nSelect Payment Mode ");
        System.out.println("1. Cash");
        System.out.println("2. Google Pay");
        //System.out.println("3. Card");
        System.out.print("Enter Choice : " + reset);
        int ch = sc.nextInt();
        if (ch == 1)
        {
            System.out.println();
            System.out.println(GREEN + "Give Your Payment to Delivery Boy at Delivery Time!!" + reset);
            delivery_Boy();
        }
        else if (ch == 2)
        {
            String mobile;
            System.out.print("Enter Mobile : ");
            sc.nextLine();
            mobile = sc.nextLine();
            Random random = new Random();
            int otp = 1000 + random.nextInt(10000);
            JOptionPane.showMessageDialog(null, "YOUR OTP IS : " + otp, "VERIFT", JOptionPane.PLAIN_MESSAGE);
            String enteredOtp = JOptionPane.showInputDialog(null, "ENTER OTP ", "enter here");
            if (otp == Integer.parseInt(enteredOtp))
            {
                JOptionPane.showMessageDialog(null, "MOBILE NUMBER VERIFIED!", "SUCCESSFUL", JOptionPane.PLAIN_MESSAGE);
            }
            System.out.println();
            System.out.println("Payment Recieved Successfully");
            delivery_Boy();
        }

        System.out.println(CYAN+"Your order will be there in few minutes"+reset);
    }
    void delivery_Boy()
    {
        String name = "k.k. Patel";
        Random rand = new Random();
        int num1;
        int num2;
        int num3;

        num1 = rand.nextInt (900) + 100;
        num2 = rand.nextInt (643) + 100;
        num3 = rand.nextInt (9000) + 1000;

        System.out.println();
        System.out.println(GREEN+"Delivery Boy Detalis");
        System.out.println("Name : "+name);
        System.out.println("MObile Number : "+num1+"-"+num2+"-"+num3+reset);
        System.out.println();
    }
}