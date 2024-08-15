public class Main {
    public static void main(String[] args) {
        System.out.println("--Дебетовая карта--");
        BankCard debitCard = new DebitCard();
        debitCard.getInfoAllCash();
        System.out.println("--После оплаты на 100");
        debitCard.payment(100);
        System.out.println("--Оплата не прошла");
        debitCard.getInfoAllCash();
        System.out.println("--После пополнения на 500");
        debitCard.topUp(500);
        debitCard.getInfoAllCash();
        System.out.println("--После оплаты на 100");
        debitCard.payment(100);
        System.out.println("--Оплата прошла");
        debitCard.getInfoAllCash();
        System.out.println();

        System.out.println("--Кредитная карта--");
        BankCard creditCard = new CreditCard(10000);
        creditCard.getInfoAllCash();
        System.out.println("--После оплаты на 100");
        creditCard.payment(100);
        System.out.println("--Оплата прошла");
        creditCard.getInfoAllCash();
        System.out.println("--После пополнения на 100");
        creditCard.topUp(100);
        creditCard.getInfoAllCash();
        System.out.println("--После пополнения на 100");
        creditCard.topUp(100);
        creditCard.getInfoAllCash();
        System.out.println("--После оплаты на 500");
        creditCard.payment(500);
        System.out.println("--Оплата прошла");
        creditCard.getInfoAllCash();
        System.out.println();

        System.out.println("--Кредитная карта с бонусной программой №1--");
        BankCard creditCardBonusProgram1 = new CreditCardBonusProgram1(5000);
        creditCardBonusProgram1.getInfoAllCash();
        System.out.println("--После пополнения на 10 000");
        creditCardBonusProgram1.topUp(10000);
        creditCardBonusProgram1.getInfoAllCash();
        System.out.println("--После оплаты на 10 000");
        creditCardBonusProgram1.payment(10000);
        creditCardBonusProgram1.getInfoAllCash();
        System.out.println("--После оплаты на 5 000");
        creditCardBonusProgram1.payment(5000);
        creditCardBonusProgram1.getInfoAllCash();
        System.out.println();

        System.out.println("--Дебетовая карта с бонусной программой №2--");
        BankCard deditCardBonusProgram2 = new DebitCardBonusProgram2();
        deditCardBonusProgram2.getInfoAllCash();
        System.out.println("--После пополнения на 100 000");
        deditCardBonusProgram2.topUp(100000);
        deditCardBonusProgram2.getInfoAllCash();
        System.out.println("--После оплаты на 100");
        deditCardBonusProgram2.payment(100);
        deditCardBonusProgram2.getInfoAllCash();
        System.out.println();

        System.out.println("--Дебетовая карта с бонусной программой №3--");
        BankCard deditCardBonusProgram3 = new DebitCardBonusProgram3();
        deditCardBonusProgram3.getInfoAllCash();
        System.out.println("--После пополнения на 10 000");
        deditCardBonusProgram3.topUp(10000);
        deditCardBonusProgram3.getInfoAllCash();
        System.out.println("--После оплаты на 5 000");
        deditCardBonusProgram3.payment(5000);
        deditCardBonusProgram3.getInfoAllCash();
        System.out.println("--После оплаты на 1 000");
        deditCardBonusProgram3.payment(1000);
        deditCardBonusProgram3.getInfoAllCash();
        System.out.println("--После оплаты на 10");
        deditCardBonusProgram3.payment(10);
        deditCardBonusProgram3.getInfoAllCash();
        System.out.println();
    }
}