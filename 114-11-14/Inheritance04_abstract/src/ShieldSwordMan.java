public class ShieldSwordMan extends SwordMan{
    private int defenseCapacity;
    // 建構子:初始化持盾劍士的名稱，生命值，攻擊力和防禦力
    public ShieldSwordMan(String name, int health, int attackPower, int defenseCapacity) {
        super(name, health, attackPower);
    }
     @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + "，造成 " +
                this.getAttackPower() + " 點傷害！"+opponent);

}
    public  int getDefenceCapacity(){
        return defenseCapacity;
    }
    public void defemce(){
       this.setHealth(this.getHealth()+defenseCapacity);
         System.out.println(this.getName()+"使用防禦力恢復了"+defenseCapacity + "點生命值！");
    }

