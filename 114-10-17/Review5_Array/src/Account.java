public class Account {
    private String ownerName;
    private double balance; // 帳戶餘額

    /**
     * 建構子，使用參數初始化帳戶名稱與餘額
     *
     * @param accountNumber 帳戶名稱
     * @param initialBalance 初始餘額
     */
    public Account(String accountNumber,String ownerName,double initialBalance) {
        this.setAccountNumber(accountNumber);
        this.ownerName = ownerName;
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤:" + e.getMessage() + "，將初始餘額設為0");
        }
    }
    public Account(String accountNumber, double initialBalance){
        this (accountNumber, ownerName="", initialBalance);
    }
    pubic Account ()
    {
        this(accountNumber, ownerName="", initialBalance);
    }

    public Account(){
        this.accountNumber = "000000";
        this.balance = 0;
    }


    /**
     * 取得帳戶名稱
     *
     * @return 帳戶名稱
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 取得帳戶餘額
     *
     * @return 帳戶餘額
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 設定帳戶名稱
     *
     * @param accountNumber 新的帳戶名稱
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * 存款方法
     *
     * @param amount 存款金額
     * @throws IllegalArgumentException 如果存款金額小於等於零
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("存款金額必須為正數");
        }
    }

    /**
     * 提款方法
     *
     * @param amount 提款金額
     * @return 是否成功提款
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 設定餘額（僅限建構子使用）
     *
     * @param balance 初始餘額
     */
    private void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("餘額必須為零或正數");
        }
    }
}

