package command;

public class RemoteControl {
    private Command slotCommand;

    public void setCommand(Command command) {
        this.slotCommand = command;
    }

    public void pressButton() {
        if (slotCommand == null) {
            System.out.println("No command assigned to this button.");
            return;
        }
        slotCommand.execute();
    }
}
