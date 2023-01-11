package com.bookorder;

import com.uber.cadence.workflow.Workflow;
import com.uber.cadence.workflow.WorkflowMethod;
import org.slf4j.Logger;

public class TestWorkflow {
    private static Logger logger = Workflow.getLogger(TestWorkflow.class);

    /*
    docker run --network=host --rm ubercadence/cli:master --do test-domain workflow start --tasklist book-order-tasklist --workflow_type Tester::test --execution_timeout 3600 --input \"World\"
     */

    public interface Tester {
        @WorkflowMethod
        void test(String name);
    }

    public static class TesterImpl implements Tester {

        @Override
        public void test(String name) {
            logger.info("Method is called with " + name);
        }
    }
}
