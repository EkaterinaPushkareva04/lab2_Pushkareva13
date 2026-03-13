public class BankAccount {
    private final String owner;
    private Double balance; // no usages
    private String accountNumber; // no usages

    private static int totalAccounts = 0; // 2 usages
    private static String bankName; // 1 usage

    static{
        bankName = "Java Bank";
        System.out.println("Банковская система инициализирована");
    }

    {
        totalAccounts++;
        System.out.println("Создание счёта #" + totalAccounts);
    }
    //constructor
    public BankAccount(String owner, double initialBalance) { // 2 usages
        this.owner=owner;
        this.balance = initialBalance;
        this.accountNumber = generateAccountNumber();
        accountNumber = "AC_"+totalAccounts;

    }

    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Счёт пополнен на " + amount);
        } else {
            System.out.println("Сумма пополнения должна быть положительной");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Ошибка: нет денег");
            System.out.println("Снято со счёта: " + amount);
        } else {
            balance -= amount;
        }
    }
    public static int getTotalAccounts(){
        return totalAccounts;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %.2f ruples", accountNumber, owner, balance);
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Анна", 1000);
        BankAccount a2 = new BankAccount("Борис", 500);

        System.out.println(a1);
        System.out.println(a2);

        a1.deposit(500);
        System.out.println("После пополнения: " + a1);

        a1.withdraw(200);
        System.out.println("После снятия: " + a1);
    }
}