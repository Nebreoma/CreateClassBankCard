import java.util.concurrent.atomic.AtomicInteger;

public class DebitCard extends BankCard {

    DebitCard() {
        this.balans.set(0);
    }

    @Override
    public boolean payment(int money) {
        if (balans.get() >= money) {
            balans.accumulateAndGet(money, (n, m) -> n - m);
            return true;
        } else
            return false;
    }

    @Override
    public void topUp(int money) {
        balans.addAndGet(money);
    }

    @Override
    public void getBalans() {
        System.out.println("Собственные средства: " + balans.get());
    }
}