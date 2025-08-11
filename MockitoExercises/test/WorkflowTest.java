import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class WorkflowTest {

    @Test
    public void testInteractionOrder() {
        // 1. Create mock
        ActionPerformer mockPerformer = mock(ActionPerformer.class);

        // 2. Inject into workflow
        Workflow workflow = new Workflow(mockPerformer);

        // 3. Execute
        workflow.execute();

        // 4. Verify method call order
        InOrder inOrder = inOrder(mockPerformer);
        inOrder.verify(mockPerformer).stepOne();
        inOrder.verify(mockPerformer).stepTwo();
    }
}
