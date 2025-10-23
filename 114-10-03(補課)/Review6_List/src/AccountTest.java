import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        List<Account> customers = new ArrayList<>();
        Account acc1 = new Account("A001","Alice",5000);
        addCustomer(customers, acc1);
        Account acc2 = new Account("A002","Bob",3000);
        addCustomer(customers, acc2);
        Account acc3 = new Account("A003","Charlie",7000);
        addCustomer(customers, acc3);

        operation(customers);
    }


    public static void operation(List<Account> customers){
        Scanner scanner = new Scanner(System.in);
        Account selectedAccount = null;
        while (true){
            menu();
            System.out.print("請選擇功能(1-3):");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.print("輸入帳戶號碼:");
                    String accNumber = scanner.next();
                    System .out.print("輸入持有人名稱:");
                    String ownerName = scanner.next();
                    System.out.print("輸入初始餘額:");
                    double initialBalance = scanner.nextDouble();
                    Account newAccount = new Account (accNumber, ownerName, initialBalance);
                    addCustomer(customers, newAccount);
                    break;
                case 2:
                    System.out.print("輸入要查詢的帳戶號碼:");
                    String searchAccNumber = scanner.nextLine();
                    selectedAccount =  customerInAction(customers, searchAccNumber);
                    printCustomerInfo(selectedAccount);
                    break;

                case 3:
                    System.out.println("\n所有客戶帳戶資料:");
                    printCustomerAccounts(customers);
                    break;
                case 4:
                    System.out.println("輸入要刪除的帳戶號碼:");
                    String deleteAccNumber = scanner.nextLine();
                    deleteCustomer(customers, deleteAccNumber);
                    break;
                case 5:
                    System.out.println("離開系統，感謝使用!");
                    return;
                default:
                    System.out.println("無效的選擇，請重新輸入");
            }
        }
    }

    public static Account customerInAction(List<Account> customers, String accountNumber){
        for (Account account : customers){
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        System.out.println("查無此帳戶號碼:" + accountNumber);
        return null;
    }

    public static void addCustomer(List<Account> customers, Account newAccount){
        customers.add(newAccount);
        System.out.println("成功新增客戶帳戶:" + newAccount.getAccountNumber());
    }
    public static void deleteCustomer(List<Account> customers, String accountNumber){
        Account accountToRemove = null;
        for (Account account : customers){
            if(account.getAccountNumber().equals(accountNumber)){
                accountToRemove = account;
                break;
            }
        }
        if(accountToRemove != null){
            customers.remove(accountToRemove);
            System.out.println("成功刪除帳戶:" + accountNumber);
        } else {
            System.out.println("查無此帳戶號碼，無法刪除:" + accountNumber);
        }
    }

    public static void printCustomerAccounts(List<Account> customers){
        for (Account account : customers){
            printCustomerInfo(account);
        }
    }

    public static void printCustomerInfo(Account account){
        if(account == null){
            System.out.println("無法列印帳戶資訊，帳戶不存在");
            return;
        }
        System.out.println("帳戶號碼:"+account.getAccountNumber()+
                ", 持有人:"+account.getOwnerName()+
                ", 餘額:"+account.getBalance());
    }

    // 功能選單: (1)新增客戶 (2)列印指定客戶帳戶資訊 (3)顯示所有客戶帳戶資訊 (4)離開
    public static void menu(){
        System.out.println("功能選單:");
        System.out.println("1.新增客戶");
        System.out.println("2.列印指定客戶帳戶資訊");
        System.out.println("3.顯示所有客戶帳戶資訊");
        System.out.println("4.刪除客戶帳戶");
        System.out.println("5.離開");
    }
}
