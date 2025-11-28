public abstract class Archer extends RangedRole {

    // 建構子：弓箭手基本屬性
    public Archer(String name, int health, int attackPower, int range, int maxEnergy) {
        super(name, health, attackPower, range, maxEnergy);
    }

    // 遠程攻擊類型
    @Override
    public String getRangedAttackType() {
        return "精準箭矢";
    }

    // 遠程攻擊實作
    @Override
    public void attack(Role opponent) {

        // 射擊前準備
        System.out.println("🏹 " + this.getName() + " 拉弓瞄準目標…");

        // 檢查能量
        if (!consumeEnergy(10)) {
            System.out.println("❌ 能量不足！無法射擊！");
            return;
        }

        // 檢查射程（假設固定距離 5）
        int distance = 5;
        if (!isInRange(distance)) {
            System.out.println("❌ 目標不在射程內！");
            return;
        }

        System.out.println("🎯 " + this.getName() + " 射出「" + getRangedAttackType() + "」攻擊 " + opponent.getName());
        opponent.takeDamage(getAttackPower());
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + this.getName() + " 的特殊技能║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：千本連射          ║");
        System.out.println("║ 技能描述：高速連發箭雨      ║");
        System.out.println("║ 技能效果：造成200%傷害      ║");
        System.out.println("╚═════════════════════════════╝");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + this.getName() + " 倒下了…");
        System.out.println("🏹 弓箭掉落在地上，箭矢散落四處。");
        System.out.println("---");
    }

    @Override
    public void prepareBattle() {
        System.out.println("🏹 " + this.getName() + " 檢查弓弦張力，調整箭矢角度…");
    }

    @Override
    public void afterBattle() {
        System.out.println("🏹 " + this.getName() + " 將弓背在身後，深深吸了一口氣。");
    }

    @Override
    public void onLevelUp() {
        System.out.println("🏹  射擊技巧大幅提升！");
    }
}
