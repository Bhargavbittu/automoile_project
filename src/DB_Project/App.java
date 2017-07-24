package DB_Project;

import DAO.AdminDaoImpl;
import DAO.OperatorDaoImpl;
import DAO.OrderDaoImpl;
import entities.Admin;
import entities.Operator;
import entities.Orders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press 1 For Login or 0 for Exit");
        int input = sc.nextInt();
        if(input == 0) {
            return;
        }
        else{
            System.out.print("Enter username and password");
            String username = sc.next();
            String password = sc.next();
            int valid = 0;
            valid = login(username, password);
            if(valid == 0){
                System.out.println("User Not Valid");
                return;
            }
            else if(valid == 1){
                System.out.println("Admin Choose From Options");
                System.out.println("1. Add Operator");
                System.out.println("2. Block Operator");
                System.out.println("3. Place Order");
                System.out.println("4. View Orders Between Dates");
                int adminOption = sc.nextInt();
                adminOperation(adminOption, sc, username);
            }
            else if(valid == 2){
                System.out.println("Operator Choose From Options");
                System.out.println("1. Place Order");
                System.out.print("2. Exit");
                int option = sc.nextInt();
                if(option == 1){
                    placeOrder(username, sc);
                }
            }
        }
    }

    private static void adminOperation(int adminOption, Scanner sc,String username) {
        OperatorDaoImpl operator = new OperatorDaoImpl();
        switch (adminOption){
            case 1: {
                System.out.println("Enter Username and Password");
                String un = sc.next();
                String password = sc.next();
                operator.addOpertor(new Operator(un, password, true));
            }
            break;
            case 2: {
                System.out.println("Enter Username");
                String un = sc.next();
                operator.blockOperator(un);
            } break;
            case 3: {
                placeOrder(username, sc);
                break;
            }
            case 4:{
                OrderDaoImpl od = new OrderDaoImpl();
                System.out.print("enter dates in dd/mm/yyyy");
                String date1 = sc.next();
                String date2 = sc.next();
                try {
                    Date date_1 = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
                    Date date_2 = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
                    List<Orders> ls = od.getOrders(date_1, date_2);
                    System.out.print(ls);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            } break;
            default:
                System.out.println("wrong choice");
                return;

        }
    }

    private static void placeOrder(String username, Scanner sc) {
        OrderDaoImpl od = new OrderDaoImpl();
        System.out.println("Enter Following detail :");
        String oId = sc.next();
        String vm = sc.next();
        String spi = sc.next();
        String spn = sc.next();
        String op = sc.next();
        int num = sc.nextInt();
        double pr = sc.nextDouble();
        double tax = sc.nextDouble();
        String dt = sc.next();
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dt);
            od.placeOrder(new Orders(username, oId, vm, spi, spn, op, num, pr, tax, date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static int login(String username, String password) {
        AdminDaoImpl admin = new AdminDaoImpl();
        OperatorDaoImpl operator = new OperatorDaoImpl();
        if(admin.validate(new Admin(username, password))) {
            return 1;
        }
        else if(operator.validate(username, password)){
            return 2;
        }
        else {
            return 0;
        }
    }


}
