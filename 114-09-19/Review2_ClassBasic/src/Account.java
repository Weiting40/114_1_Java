/**
 * Account 類別
 * 此類別用於表示帳戶，包含帳戶名稱的設定與取得方法。
 */
public class Account {
    private String name; // 帳戶名稱

    /**
     * 建構子，使用參數初始化帳戶名稱
     * @param name 帳戶名稱
     */
    public Account(String name) {
        this.name = name; // 指定帳戶名稱
    }

    /**
     * 設定帳戶名稱
     * @param name 新的帳戶名稱
     */
    public void setName(String name) {
        this.name = name; // 儲存帳戶名稱
    }

    /**
     * 取得帳戶名稱
     * @return 帳戶名稱
     */
    public String getName() {
        return name; // 回傳帳戶名稱
    }
}
