// java
public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account("A123", 1000.0);

        System.out.printf("帳戶號碼: %s%n初始餘額:%.2f%n", account1.getAccountNumber(), account1.getBalance());

        boolean success = account1.withdraw(500.0);
        System.out.printf("帳戶號碼: %s%n提款後餘額:%.2f%n", account1.getAccountNumber(), account1.getBalance());

        try {
            account1.deposit(-100.0);
            System.out.printf("帳戶號碼: %s%n存款後餘額:%.2f%n", account1.getAccountNumber(), account1.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("存款錯誤:" + e.getMessage());
        }

        try {
            account1.deposit(2000.0);
            System.out.printf("帳戶號碼: %s%n存款後餘額:%.2f%n", account1.getAccountNumber(), account1.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("存款錯誤:" + e.getMessage());
        }
    }
}



