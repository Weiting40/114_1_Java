public abstract class MeleeRole extends Role {
    private int armor; // 近戰角色特有

    public MeleeRole(String name, int health, int attackPower, int armor) {
        super(name, health, attackPower);
        this.armor = armor;
    }

    public int getArmor() { return armor; }
    public void setArmor(int armor) { this.armor = armor; }

    // 計算傷害減免
    public int calculateDefense(int incomingDamage) {
        return Math.max(0, incomingDamage - armor);
    }

    // 抽象方法
    public abstract String getWeaponType();
    protected abstract void onMeleePrepare();

    @Override
    public void takeDamage(int damage) {
        int reduced = calculateDefense(damage);
        super.takeDamage(reduced);
    }
}
