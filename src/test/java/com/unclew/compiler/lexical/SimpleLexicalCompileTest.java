package com.unclew.compiler.lexical;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by wuyingqiang
 * on 2020/4/5-4:57 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class SimpleLexicalCompileTest {
    private LexicalCompiler lexicalCompiler;

    @Before
    public void beforeRun() {
        String str = "int age; age = 46; 2 + 3 * 56; age > 30; age >= 40;";
        lexicalCompiler = new LexicalCompiler(str);
    }

    @Test
    public void testParsing() {
        SimpleTokenMachine tokenMachine = lexicalCompiler.parsing();
        System.out.println();
        System.out.println(tokenMachine);
    }


}
