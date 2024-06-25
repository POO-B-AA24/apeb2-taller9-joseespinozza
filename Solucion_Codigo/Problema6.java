class CuentaBancaria {
    private int numeroCuenta;
    private String nombreCliente;
    protected double balance;

    public CuentaBancaria(int numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0.0;
    }

    public void depositar(double cantidad) {
        balance += cantidad;
    }

    public boolean retirar(double cantidad) {
        if (balance >= cantidad) {
            balance -= cantidad;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

class CuentaCheques extends CuentaBancaria {
    public CuentaCheques(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }
}

class CuentaAhorros extends CuentaBancaria {
    private double interesMensual;

    public CuentaAhorros(int numeroCuenta, String nombreCliente, double interesMensual) {
        super(numeroCuenta, nombreCliente);
        this.interesMensual = interesMensual;
    }

    public void calcularInteres() {
        balance += balance * interesMensual;
    }
}

class CuentaPlatino extends CuentaAhorros {
    public CuentaPlatino(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente, 0.10);
    }
}

public class BancoApp {
    public static void main(String[] args) {
        CuentaCheques cuenta1 = new CuentaCheques(1001, "Juan");
        cuenta1.depositar(1000);
        cuenta1.retirar(200);

        CuentaAhorros cuenta2 = new CuentaAhorros(2001, "María", 0.02);
        cuenta2.depositar(1500);
        cuenta2.calcularInteres();

        CuentaPlatino cuenta3 = new CuentaPlatino(3001, "Pedro");
        cuenta3.depositar(5000);
        cuenta3.calcularInteres();

        System.out.println("Balance cuenta1: $" + cuenta1.getBalance());
        System.out.println("Balance cuenta2: $" + cuenta2.getBalance());
        System.out.println("Balance cuenta3: $" + cuenta3.getBalance());
    }
}
