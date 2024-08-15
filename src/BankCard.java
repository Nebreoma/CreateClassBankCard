import java.util.concurrent.atomic.AtomicInteger;

public abstract class BankCard {
    protected AtomicInteger balans = new AtomicInteger();
    protected AtomicInteger creditFunds;

    public abstract boolean payment(int money);

    public abstract void topUp(int money);

    public abstract void getBalans();

    public void getInfoAllCash() {
        System.out.println("Собственные средства: " + balans.get());
        if (creditFunds != null)
            System.out.println("Кредитные средства: " + creditFunds.get());
    }
}