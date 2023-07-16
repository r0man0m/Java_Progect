import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;;

public class Delivery_Service {

    public static void main(String[] args) throws IOException 
    {
       
        Scanner sc = new Scanner(System.in);
        Staff p = new Staff();
        int i = 0;
        int ch = 0;
        
        do {
            System.out.println("1) Add an order to the queue.");
            System.out.println("2) Delete the order from the queue.");
            System.out.println("3) Count orders.");
            System.out.println("4) Display information on a monitor.");
            System.out.println("0) Exit the program.");
            System.out.println("?");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1: {
                    p.add_order(); 
                    do  {
                        String pr = (""+p.qu.arc[i].price);
                        String quant = (p.qu.arc[i].q +"");
                        FileWriter  myF= new FileWriter("my_information.txt");
                        myF.write(p.qu.arc[i].name);
                        myF.write("\n");
                        myF.write(p.qu.arc[i].address);
                        myF.write("\n");
                        myF.write(p.qu.arc[i].pizza_name);
                        myF.write("\n");
                        myF.write(pr);
                        myF.write("\n");
                        myF.write(quant);
                        myF.write("\n");
                        myF.write("\n");
                        myF.close();
                        i++;

                    }
                    while(i <= p.qu.e);
                        FileReader myFiler = new FileReader("my_information.txt");
                        Scanner scan = new Scanner(myFiler);
                        int a = 1;
                        while (scan.hasNextLine()) {
                            System.out.println(a + ": " + scan.nextLine());
                                i++;
                            }
                        scan.close();
                        myFiler.close();
                    
                    break;
                }
                case 2:
                   p.del_order();
                    break;
                case 3:
                    p.count();
                    break;
                case 4:
                    p.disp_monitor();
                    break;
                case 0:
                    System.out.println(" Exit the program.");
            }

        } while (ch != 0);
        
       
    }

}

 class Order {

    String name;
    String address;
    String pizza_name;
    double price;
    int q;

}

class Queue_Order

{ 
 
    int t;
    int e = 0;
    int x = 0;
    Order arc[] = new Order[10];

    void set_q(Order ord, int c) {
        e = c;
        arc[e] = ord;
    }
    void del_q()    {
    
        do {
            arc[x] = arc[x+1];
            x++;
            e--;
        }
        while (x < e);
    }
      void count_order()  {
          if(arc[x] == null)
          System.out.println("All orders deleted! \n");
          else
        System.out.println("Amount of orders "+(e+1)+'\n');
    }

    void show(int a) {
        if (arc[x] != null) {
        t = a - 1;
        double w;
        w = arc[t].price * arc[t].q;
        System.out.println("_____________________________________");
        System.out.println("Name: "+arc[t].name);
        System.out.println("Adress: "+arc[t].address);
        System.out.println("Pizza name: "+arc[t].pizza_name);
        System.out.println("Cost of pizza: "+arc[t].price);
        System.out.println("Quantity: "+arc[t].q);
        System.out.println("Whole: "+ w );
        System.out.println("______________________________________");
        }
        else
            System.out.println("All orders deleted! \n");
    }
}

class Staff {
   
    int c = 0;
    int i = 1;
     Queue_Order qu = new Queue_Order();
     Scanner sc = new Scanner(System.in);
    
    void add_order() {
        do {
            Order ord = new Order();
            System.out.println("Enter the name.");
            ord.name = sc.nextLine();
            System.out.println("Enter the address");
            ord.address = sc.nextLine();
            System.out.println("");
            System.out.println("Enter the order.");
            System.out.println("Enter the name of the pizza.");
            ord.pizza_name = sc.nextLine();
            System.out.println("Enter the cost of the pizza.");
            ord.price = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter the quantity.");
            ord.q = sc.nextInt();
            sc.nextLine();
            qu.set_q(ord, c);
            c++;
            System.out.println("Finish order 0-yes 1-no.");
            i = sc.nextInt();
            sc.nextLine();
        } while (!(i == 0));
    }
    void del_order()    {
        qu.del_q();
        System.out.println("Deleted! \n");   
    }
  
    void disp_monitor() {
        
        System.out.println("What is order display?");
            c = sc.nextInt();
            sc.nextLine();
            qu.show(c);
    }
    void count(){
        qu.count_order();
    }
}
