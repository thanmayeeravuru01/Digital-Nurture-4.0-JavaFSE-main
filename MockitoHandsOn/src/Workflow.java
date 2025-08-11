public class Workflow {
    private ActionPerformer performer;

    public Workflow(ActionPerformer performer) {
        this.performer = performer;
    }

    public void execute() {
        performer.stepOne();
        performer.stepTwo();
    }
}
