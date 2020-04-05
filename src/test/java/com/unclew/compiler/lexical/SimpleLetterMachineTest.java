package com.unclew.compiler.lexical;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by wuyingqiang
 * on 2020/4/5-12:19 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class SimpleLetterMachineTest {
    private ItemScanningFactory<Character> letterMachine;

    @Before
    public void beforeSetup() {
        String str = "int allkdjasld";

        letterMachine = new SimpleILetterMachine(str);
    }

    @Test
    public void testReading() {
        char c1 = letterMachine.preview();
        letterMachine.read();
        letterMachine.unread();
        char c2 = letterMachine.preview();

        assert c1 == c2;
    }

    @Test
    public void testPreview(){
        letterMachine.reset();
        while(!letterMachine.isTail()) {
            letterMachine.read();
        }

        assert letterMachine.preview() == null;
    }

}
