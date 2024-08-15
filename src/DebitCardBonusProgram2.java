//Накопление в размере 0.005% от суммы пополнений

public class DebitCardBonusProgram2 extends DebitCard {

    private final int replenishmentCardBonus = 5;

    @Override
    public void topUp(int money) {
        money += (money * replenishmentCardBonus / 100000);
        balans.addAndGet(money);
    }
}