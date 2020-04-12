package com.unclew.compiler.lexical;

import com.unclew.compiler.lexical.statemachine.utils.SimpleTokenScanner;
import com.unclew.compiler.lexical.statemachine.utils.TokenScanner;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wuyingqiang
 * on 2020/4/12-5:08 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class SimpleTokenScannerTest {
    private TokenScanner scanner;

    @Before
    public void beforeStartup() {
        String str = "ksadgasdghaskjdgaksjgdaksjgdas";
        scanner = new SimpleTokenScanner(str);
    }

    @Test
    public void testPeek() {
        scanner.reset();
        char c1 = scanner.peek();
        char c2 = scanner.peek();

        assert c1 == c2;
    }

    @Test
    public void testRead() {
        scanner.reset();
        Character c = null;

        while ((c = scanner.read()) != null) {
            System.out.print(c);
        }

        c = scanner.read();
        assert c == null;
    }

    @Test
    public void testUnset() {
        int count = 5;
        Character c1 = scanner.peek();

        for(int i = 0; i < count; i++) {
            scanner.read();
        }


        scanner.unset(count);
        Character c2 = scanner.peek();

        assert c2 == c1;
    }
}
