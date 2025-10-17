public class AccountTest {
    private int customerCount = 0;
    public static void main(String[] args) {
        Account[]  customers= new Account[10];
        Account acc1 = new Account("A001","Alice",5000);
        addCustomer(customers,acc1);
        Account acc2 = new Account("A002","Bob",3000);
        addCustomer(customers,acc2);
        Account acc3 = new Account("A003","Charlie",7000);
        addCustomer(customers,acc3);
    }
    public static void addCustomer(Account[] customers,Account newAccount){
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null){
                customers[i] = newAccount;
                System.out.printf("新增客戶:",newAccount.getAccountNumber()+",餘額:"+newAccount
                        newAccount.getAccountNumber(),
                        newAccount.getBalance());
                return;
            }
        }
        System.out.println("無法新增客戶，客戶數量已達上限");
    }
}


