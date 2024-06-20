import cashback.impl.*;

public class Main {
    public static void main(String[] args) {
//        CreditCard creditCard = new CreditCard(10_000.00);
//        creditCard.increase(5000.00);
//        creditCard.pay(5000);
//        creditCard.pay(3000);
//        creditCard.increase(2000);
//        creditCard.increase(2000);
//        System.out.println(creditCard.getInformationAboutAvailableFunds());

//        StudentDebitCard studentDebitCard = new StudentDebitCard();
//
//        studentDebitCard.setBonusProgram(new StudentBonusProgram());
//        studentDebitCard.setCashBackProgram(new StudentCashBack());
//        studentDebitCard.setAccumulation(new StudentAccumulationProgram());
//        studentDebitCard.increase(50_000.00);
//        studentDebitCard.pay(10_000.00);
//        System.out.println(studentDebitCard.getInformationAboutAvailableFunds());
//        studentDebitCard.pay(1000.0);
//        studentDebitCard.increase(1000.0);
//        System.out.println(studentDebitCard.getInformationAboutAvailableFunds());

//        VIPDebitCard vipDebitCard = new VIPDebitCard();
//        vipDebitCard.setBonusProgram(new VIPBonusProgram());
//        vipDebitCard.setAccumulationProgram(new VIPAccumulationProgram());
//        vipDebitCard.setCashBackProgram(new VIPCashBackProgram());
//
//        vipDebitCard.increase(100_000.00);
//        vipDebitCard.pay(20_000);
//        vipDebitCard.pay(10_000.00);
//        System.out.println(vipDebitCard.getInformationAboutAvailableFunds());

//        GoldCreditCard goldCreditCard = new GoldCreditCard();
//        goldCreditCard.pay(10_000.00);
//        goldCreditCard.pay(10_000.00);
//        goldCreditCard.pay(10_000.00);
//        goldCreditCard.pay(10_000.00);
//        goldCreditCard.pay(10_000.00);
//        System.out.println(goldCreditCard.getInformationAboutAvailableFunds());

        PlatinumCreditCard platinumCreditCard = new PlatinumCreditCard();
        platinumCreditCard.pay(100_000.00);
        platinumCreditCard.increase(200_000.00);
        System.out.println(platinumCreditCard.getInformationAboutAvailableFunds());
    }
}
