public class Magician extends Role {

    private int  healPower;


    public Magician(String name, int health, int attackPower, int healthPower) {
        super(name, health, attackPower);
        this.healPower = healthPower;
    }
   public int getHealPower() {
        return healPower;
    }
    // 攻擊方法:對對手造成傷害
    public void attack(Magician opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 攻擊 " + opponent.getName() + "，造成 " + this.getAttackPower() + " 點傷害！");
    }
    // 治療方法:為隊友恢復生命值
    public void heal(SwordMan ally) {
        ally.setHealth(ally.getHealth() + this.healPower );
        System.out.println(this.getName() + " 治療" + ally.getName() + "恢復 " + healPower + " 點生命值！");
    }
    @Override
    public String toString() {
        return super.toString()+", 治療力: " + healPower;
    }
}
