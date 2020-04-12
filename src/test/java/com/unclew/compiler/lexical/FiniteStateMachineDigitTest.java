package com.unclew.compiler.lexical;

import com.unclew.compiler.lexical.common.FiniteToken;
import com.unclew.compiler.lexical.statemachine.FiniteStateMachine2;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wuyingqiang
 * on 2020/4/12-6:19 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class FiniteStateMachineDigitTest {
    private FiniteStateMachine2 machine;

    @Before
    public void setup() {
        machine = new FiniteStateMachine2();
    }

    @Test
    public void testNumber() {
        String seq = "12345";
        machine.setSequence(seq);
        machine.parsing();

        System.out.println(machine);
        FiniteToken t = machine.get(0);
        assert t != null && t.text().equals(seq);
    }

    @Test
    public void testDecimal() {
        String seq = "123.456";
        machine.setSequence(seq);
        machine.parsing();
        System.out.println(machine);
        FiniteToken t = machine.get(0);
        assert t != null && t.text().equals(seq);
    }
}
