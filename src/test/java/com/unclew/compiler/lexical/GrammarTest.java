package com.unclew.compiler.lexical;

import com.unclew.compiler.grammar.ASTNode;
import com.unclew.compiler.grammar.GrammarCompiler;
import com.unclew.compiler.grammar.common.AST;
import com.unclew.compiler.grammar.utils.SimpleTokenMachine;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wuyingqiang
 * on 2020/4/5-8:34 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class GrammarTest {
    private GrammarCompiler compiler;

    @Before
    public void beforeSetup() {
        compiler = new GrammarCompiler();
    }

    @Test
    public void testIntDeclaration() throws Exception {
        String str = "int age;";
        LexicalCompiler lexicalCompiler = new LexicalCompiler(str);
        SimpleTokenMachine tokenMachine = lexicalCompiler.parsing();

        AST intDeclarationNode = compiler.intDeclaration(tokenMachine);
        System.out.println();
        System.out.println(intDeclarationNode);
    }
}
