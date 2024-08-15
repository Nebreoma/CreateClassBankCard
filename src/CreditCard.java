import java.util.concurrent.atomic.AtomicInteger;

public class CreditCard extends BankCard {

    private final int creditLimit;

    //конструктор
    CreditCard(int limit) {
        this.creditLimit = limit;
        creditFunds = new AtomicInteger(limit);
    }

    //метод оплаты кредиткой
    @Override
    public boolean payment(int money) {
        //creditFunds -> 0 от лимита
        //баланс -> 0
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

    //метод пополнения
    @Override
    public void topUp(int money) {
        //creditFunds -> + к лимиту
        //баланс -> +
        int oldCreditFunds = creditFunds.get();
        if (oldCreditFunds == creditLimit) {
            balans.addAndGet(money);
        } else if ((creditLimit - oldCreditFunds) >= money) {
            creditFunds.addAndGet(money);
        } else {
            money -= creditLimit - creditFunds.get();
            creditFunds.set(creditLimit);
            balans.addAndGet(money);
        }
    }

    @Override
    public void getBalans() {
        System.out.println("Кредитные средства: " + creditFunds.get());
        System.out.println("Собственные средства: " + balans.get());
    }

}