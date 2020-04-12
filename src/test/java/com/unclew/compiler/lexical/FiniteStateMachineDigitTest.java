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

    @Test
    public void testEnd() {
        String seq = ";";
        machine.setSequence(seq);
        machine.parsing();
        System.out.println(machine);
        FiniteToken t = machine.get(0);
        assert t != null && t.text().equals(seq);
    }

    @Test
    public void testAssignment() {
        String seq = "=";
        testToken(seq);
    }

    @Test
    public void testEqual() {
        String seq = "==";
        testToken(seq);
    }

    private void testToken(String token) {
        machine.setSequence(token);
        machine.parsing();
        System.out.println(machine);
        FiniteToken t = machine.get(0);
        assert t != null && t.text().equals(token);
    }

    @Test
    public void testDigitAndEnd() {
        String seq = "12345;123.456";
        machine.setSequence(seq);
        machine.parsing();
        System.out.println(machine);
        assert machine.get(0) != null && machine.get(0).text().equals("12345");
        assert machine.get(1) != null && machine.get(1).text().equals(";");
        assert machine.get(2) != null && machine.get(2).text().equals("123.456");
    }
}
