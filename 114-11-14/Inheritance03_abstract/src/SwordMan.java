public class  SwordMan extends Role {
    // 建構子:初始化名稱、生命值與攻擊力
    public SwordMan(String name, int health, int attackPower) {

        super(name, health, attackPower);
    }
    // 攻擊方法:對對手造成傷害
    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + "，造成 " +
                this.getAttackPower() + " 點傷害！"+opponent);
    }


}
