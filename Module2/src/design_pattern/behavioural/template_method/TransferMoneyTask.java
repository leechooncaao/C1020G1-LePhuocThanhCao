package design_pattern.behavioural.template_method;

public class TransferMoneyTask extends Task {
    @Override
    protected void doExecute() {
        System.out.println("Transfer money..");
    }
}
