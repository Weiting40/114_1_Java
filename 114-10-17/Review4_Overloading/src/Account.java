public class Account {
    private String accountNumber;
    private double balance; // 帳戶餘額

    /**
     * 建構子，使用參數初始化帳戶名稱與餘額
     *
     * @param accountNumber 帳戶名稱
     * @param initialBalance 初始餘額
     */
    public Account(String accountNumber, double initialBalance) {
        this.setAccountNumber(accountNumber);
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤:" + e.getMessage() + "，將初始餘額設為0");
            this.balance = 0;
        }
    }
    public Account ()
    {
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

    public void deposit(int amount, String currency) {
        double convertedAmount;
        switch (currency) {
            case "USD":
                convertedAmount = amount * 30.0; // 假設1 USD = 30 TWD
                break;
            case "EUR":
                convertedAmount = amount * 33.0; // 假設1 EUR = 33 TWD
                break;
            case "JPN":
                convertedAmount = amount * 0.28; // 假設1 JPN = 0.28 TWD
                break;
            default:
                throw new IllegalArgumentException("不支援的貨幣類型");
        }
        this.deposit(convertedAmount);
    }
    public void deposit (double... amounts) {
        for(double amount : amounts){
            if (amount <= 0) {
                throw new IllegalArgumentException("存款金額必須為正數: " + amount);
            }
            this.balance += amount;
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
