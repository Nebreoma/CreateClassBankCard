//Потенциальный кэшбэк 5% от покупок при условии трат больше 5 000 тыс.

public class CreditCardBonusProgram1 extends CreditCard {

    private final int cashback = 5;
    private final int minExpenses = 5000;

    CreditCardBonusProgram1(int limit) {
        super(limit);
    }

    @Override
    public boolean payment(int money) {
        //creditFunds -> 0 от лимита
        //баланс -> 0
        int cashbackMoney;
        if (minExpenses <= money) {
            cashbackMoney = money * cashback / 100;
            balans.addAndGet(cashbackMoney);
        }

        int ownFunds = balans.get();
        if (ownFunds > 0) {
            if (ownFunds > money) {
                balans.accumulateAndGet(money, (n, m) -> n - m);
                return true;
            } else {
                money -= ownFunds;
                if (creditFunds.get() > money) {
                    creditFunds.accumulateAndGet(money, (n, m) -> n - m);
                    balans.accumulateAndGet(ownFunds, (n, m) -> n - m);
                    return true;
                } else
                    return false;
            }
        } else if (creditFunds.get() < money) {
            return false;
        } else {
            creditFunds.accumulateAndGet(money, (n, m) -> n - m);
            return true;
        }
    }
}