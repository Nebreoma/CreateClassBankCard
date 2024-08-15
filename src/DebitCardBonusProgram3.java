//Бонусные баллы в размере 1% от покупок

public class DebitCardBonusProgram3 extends DebitCard {

    private final int paymentBonusBall = 1;
    private int bonusBall = 0;

    @Override
    public boolean payment(int money) {
        int cash = balans.get();
        int price = money;
        if (cash + bonusBall > money) {
            if (bonusBall > 0) {
                if (bonusBall > money) {
                    bonusBall -= money;
                    return true;
                }
                money -= bonusBall;
                bonusBall = 0;
            }
            balans.accumulateAndGet(money, (n, m) -> n - m);
            bonusBall += (price * paymentBonusBall / 100);
            return true;
        } else
            return false;
    }

    @Override
    public void getInfoAllCash() {
        System.out.println("Собственные средства: " + balans.get());
        if (bonusBall > 0)
            System.out.println("Бонусные баллы: " + bonusBall);

    }
}