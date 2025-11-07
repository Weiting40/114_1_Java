public class RPG {
    public static void main(String[] args) {
        SwordMan swordMan_light  = new SwordMan("光明劍士", 100, 20);
        SwordMan swordMan_dark = new SwordMan("黑暗劍士", 100, 25);
        Magician magician_light = new Magician("光明法師", 80, 15, 30);
        Magician magician_dark = new Magician("黑魔法師", 80, 18, 20);

        System .out.println("戰鬥開始！");
        swordMan_light.attack(swordMan_dark);
        magician_dark.attack(magician_light);
        magician_dark.heal(swordMan_dark);
        System.out.println("戰鬥結束！");
    }
}
