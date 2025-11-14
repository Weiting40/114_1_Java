public class RPG {
    public static void main(String[] args) {
        SwordMan swordMan_light = new SwordMan("光明劍士", 100, 20);
        SwordMan swordMan_dark = new SwordMan("黑暗劍士", 100, 25);

        Magician magician_light = new Magician("光明法師", 80, 15, 30);
        Magician magician_dark = new Magician("黑魔法師", 80, 18, 20);

        Role[] gameRoles = {swordMan_light, swordMan_dark, magician_light, magician_dark,shieldSwordMan};

        System.out.println("戰鬥開始！");
        for (Role currentRole : gameRoles) {
            if (!currentRole.isAlive()) {
                continue;
            }
            if (currentRole instanceof SwordMan) {
                Role target = gameRoles[(int) (Math.random() * gameRoles.length)];
               if(target instanceof ShieldSwordMan)
                {
                 ((ShieldSwordMan) target).defemce();
                }
                else{
                 currentRole.attack(target);
                }
            } else if (currentRole instanceof Magician) {
                Magician magician = (Magician) currentRole;
                if (Math.random() < 0.5) {
                    currentRole.attack(gameRoles[(int) (Math.random() * gameRoles.length)]);
                } else {
                    currentRole.heal(gameRoles[(int) (Math.random() * gameRoles.length)]);
                }
            }
        }
    }
}
