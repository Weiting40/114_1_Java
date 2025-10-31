import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        List<Account> customers = new ArrayList<>();
        Account acc1 = new Account("A001",ownerName:"Alice",ownerID:A12345678,initialBalance:5000);
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
            System.out.print("請選擇功能(1-7):");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("請輸入數字選項");
                continue;
            }
            switch (choice){
                case 1:
                    System.out.print("輸入帳戶號碼:");
                    String accNumber = scanner.nextLine().trim();
                    System.out.print("輸入持有人名稱:");
                    String ownerName = scanner.nextLine().trim();
                    System.out.print("輸入初始餘額:");
                    double initialBalance;
                    try {
                        initialBalance = Double.parseDouble(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("輸入金額格式錯誤，新增失敗");
                        break;
                    }
                    Account newAccount = new Account (accNumber, ownerName, initialBalance);
                    addCustomer(customers, newAccount);
                    break;
                case 2:
                    System.out.print("輸入要查詢的帳戶號碼:");
                    String searchAccNumber = scanner.nextLine().trim();
                    selectedAccount =  customerInAction(customers, searchAccNumber);
                    printCustomerInfo(selectedAccount);
                    break;

                case 3:
                    System.out.println("\n所有客戶帳戶資料:");
                    printCustomerAccounts(customers);
                    break;
                case 4:
                    System.out.print("輸入要刪除的帳戶號碼:");
                    String deleteAccNumber = scanner.nextLine().trim();
                    deleteCustomer(customers, deleteAccNumber);
                    break;
                case 5: // 存款
                    System.out.print("輸入要存款的帳戶號碼:");
                    String depAcc = scanner.nextLine().trim();
                    Account accDep = customerInAction(customers, depAcc);
                    if (accDep != null) {
                        System.out.print("輸入存款金額:");
                        double depAmount;
                        try {
                            depAmount = Double.parseDouble(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("金額格式錯誤");
                            break;
                        }
                        try {
                            accDep.deposit(depAmount);
                            System.out.printf("存款成功，帳戶 %s 現在餘額: %.2f\n", accDep.getAccountNumber(), accDep.getBalance());
                        } catch (IllegalArgumentException e) {
                            System.out.println("存款失敗: " + e.getMessage());
                        }
                    }
                    break;
                case 6: // 提款
                    System.out.print("輸入要提款的帳戶號碼:");
                    String witAcc = scanner.nextLine().trim();
                    Account accWit = customerInAction(customers, witAcc);
                    if (accWit != null) {
                        System.out.print("輸入提款金額:");
                        double witAmount;
                        try {
                            witAmount = Double.parseDouble(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("金額格式錯誤");
                            break;
                        }
                        try {
                            accWit.withdraw(witAmount);
                            System.out.printf("提款成功，帳戶 %s 剩餘餘額: %.2f\n", accWit.getAccountNumber(), accWit.getBalance());
                        } catch (IllegalArgumentException e) {
                            System.out.println("提款失敗: " + e.getMessage());
                        }
                    }
                    break;
                case 7:
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
        System.out.println(account.toString());
    }

    // 功能選單: (1)新增客戶 (2)列印指定客戶帳戶資訊 (3)顯示所有客戶帳戶資訊 (4)離開
    public static void menu(){
        System.out.println("功能選單:");
        System.out.println("1.新增客戶");
        System.out.println("2.列印指定客戶帳戶資訊");
        System.out.println("3.顯示所有客戶帳戶資訊");
        System.out.println("4.刪除客戶帳戶");
        System.out.println("5.存款");
        System.out.println("6.提款");
        System.out.println("7.離開");
    }
}
