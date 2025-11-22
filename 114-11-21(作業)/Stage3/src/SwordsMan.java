public class SwordsMan extends MeleeRole {

    // 新建構子：需要傳 armor
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower, 5); // 劍士預設 armor = 5
    }

    // 近戰準備動作（抽象方法實作）
    @Override
    protected void onMeleePrepare() {
        System.out.println("🛡️ " + this.getName() + " 擺出架勢，準備揮劍攻擊！");
    }

    // 近戰武器類型
    @Override
    public String getWeaponType() {
        return "雙手劍";
    }

    // 攻擊方法（你原本的 + 近戰流程）
    @Override
    public void attack(Role opponent) {
        onMeleePrepare();  // 新增：來自 MeleeRole
        System.out.println("✈️ " + this.getName() + " 揮劍攻擊 " + opponent.getName() + " !");
        opponent.takeDamage(this.getAttackPower());
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + this.getName() + " 的特殊技能║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：群體治療          ║");
        System.out.println("║ 技能描述：治療所有隊友      ║");
        System.out.println("║ 技能效果:造成150%傷害      ║");
        System.out.println("╚═════════════════════════════╝");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + this.getName() + " 倒下了...");
        System.out.println("⚔️  " + this.getName() + " 的劍掉落在地上，發出清脆的聲響。");
        System.out.println("---");
    }

    @Override
    public void prepareBattle() {
        System.out.println("🗡️  " + this.getName() + " 擦拭劍刃，劍身反射出凜冽的寒光...");
    }

    @Override
    public void afterBattle() {
        System.out.println("🗡️  " + this.getName() + " 將劍收入劍鞘。");
    }

    @Override
    public void onLevelUp() {
        System.out.println("⚔️  劍技更加精湛！");
    }
}
