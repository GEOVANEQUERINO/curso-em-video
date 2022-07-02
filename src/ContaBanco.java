public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;


    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void abrirConta(String tipo){
        setTipo(tipo);
        setStatus(true);
        if (getTipo().equals("CC")){
            setSaldo(50.00);
        }if(getTipo().equals("CP")){
            setSaldo(150.00);
        }else {
            System.out.println("Opção inválida");
        }

    }

    public void fecharConta(){
        if(getSaldo() > 0){
            System.out.println("Conta com saldo!!!!");
        }if (getSaldo() < 0) {
            System.out.println("Conta com saldo devedor!!!!");
        }else {
            setStatus(false);
        }

    }

    public void depositar(double v){
        if (getStatus() == true){
            setSaldo(getSaldo()+v);
            System.out.println("Deposito feito com sucesso!!");
        }else {
            System.out.println("Conta não existe ou fechada!!!!");
        }

    }

    public void sacar(double v){
        if (getStatus() == true){
            if(getSaldo() > v){
                setSaldo(getSaldo()-v);
                System.out.println("Saque feito com sucesso");
                System.out.println("Seu saldo é de R$ " + getSaldo());
            }else {
                System.out.println("Saldo insuficiente!!!");
            }
        }

    }

    public void pagarMensalidade(){
        double v = 0;
        if(getTipo().equals("CC")){
            v = 12.00;
        }if(getTipo().equals("CP")){
            v = 20.00;
        }else {
            System.out.println("Conta inválida");
        }

        if(getStatus() == true){
            if(getSaldo() > v){
                setSaldo(getSaldo()-v);
                System.out.println("Mensalidade paga");
                System.out.println("Saldo de R$ " + getSaldo());
            }else {
                System.out.println("Saldo insuficiente");
            }
        }

    }
}
