package menu;
import BnkDbService.BnkService;
import db.BankingConnection;
import java.sql.SQLException;
import java.util.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    BankingConnection connection = new BankingConnection();
    BnkService service = new BnkService(connection.getConnection());

    public Menu() throws SQLException, ClassNotFoundException {
    }

    private String prepareMenu() {
        String title = "\n --- Banking System ---";
        String m1 = "\n 1. Create New Account";
        String m2 = "\n 2. Show All Accounts";
        String m3 = "\n 3.Display balance ";
        String m4 = "\n 4. transfer money";
        String m5 = "\n 5. withdraw";
        String m6 = "\n 6. deposit";
        String m7 = "\n 7.activate acc";
        String m8 = "\n 8.Deactivate acc";
        String m9 = "\n 9. Exit";

        return title + m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9;
    }

    public void showMenu() throws SQLException{
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println(prepareMenu());
            System.out.println(" *) enter the number : ");
            int ch = scanner.nextInt();


            if (ch == 9) System.exit(1);
            if (ch == 1) {
                System.out.println("Enter Account Number : ");
                int ac_num = scanner.nextInt();

                System.out.println("Enter Balance : ");
                int amount = scanner.nextInt();

                System.out.println("Enter Name : ");
                String ac_hl_nm = scanner.nextLine();
                System.out.println("enter the date ");
                Date dt = Date.valueOf(scanner.nextLine());
                System.out.println("enter the status");
                Boolean status = Boolean.valueOf(scanner.nextLine());
                service.createBnkAcc(ac_num, amount, ac_hl_nm, dt, status);


// service.createBnkAcc(5,500,"Tejaswini", Date.valueOf(LocalDate.now()),true);


            }
            if (ch == 2) {
// System.out.println("Enter the acc_hl_nm");
// String ac_hl_nm=scanner.nextLine();
                service.showAllAcc();

            }
            if (ch == 3) {
                System.out.println("enter the ac_hl_nm");
                String ac_hl_nm = scanner.next();
                service.checkBalance(ac_hl_nm);
            }
            if (ch == 4) {
                System.out.println("enter the transfer acc_num");
                int num = scanner.nextInt();
                System.out.println("enter the 2nd acc_num");
                int num2 = scanner.nextInt();
                System.out.println("enter the amount");
                int amt = scanner.nextInt();


                service.Transfer(num, amt, num2);
            }
            if (ch == 5) {
                System.out.println("enter the amount to withdraw");
                int amount = scanner.nextInt();
                System.out.println("enter the ac_num to withdraw the money");
                int ac_num = scanner.nextInt();
                service.withdraMoney(amount, ac_num);
            }
            if (ch == 6) {
                System.out.println("deposit money");
                int amount = scanner.nextInt();
                System.out.println("enter the ac_num for depositing the money");
                int ac_num = scanner.nextInt();
                service.deposit(amount, ac_num);
            }
            if (ch == 7) {
                System.out.println("enter the name to activation ");
                String acc = scanner.next();
                System.out.println("enter the status for activation");
                boolean sat = scanner.hasNext();
                service.activate(acc, sat);

            }
            if (ch == 8) {
                System.out.println("enter the name to deactivate");
                String acc = scanner.next();
                System.out.println("enter the status for deactivation");
                boolean stat = scanner.hasNext();
                service.Deactivate(acc, stat);

            }
        }
    }

}
