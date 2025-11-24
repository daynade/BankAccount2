package ie.atu;

public class BankAccount {
    private String accNo;
    private String name;
    private double balance;

    public BankAccount(String accNo, String name, double balance)
    {
        if(balance <= 0)
        {
            throw new IllegalArgumentException("Balance must be greater than 0.");
        }

        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public BankAccount()
    {

    }

    public String getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double add(double balance, double deposit) {
        if (deposit <= 0) {
            throw new IllegalArgumentException("Deposit must be greater than 0.");
        }
        return balance + deposit;
    }


    public double withdraw(double balance, double withdrawal) {
        if (withdrawal <= 0) {
            throw new IllegalArgumentException("Withdrawal must be greater than 0.");
        }
        else if (balance < withdrawal) {
            throw new IllegalArgumentException("Withdrawal can not exceed balance.");
        }
        return balance - withdrawal;
    }
}
