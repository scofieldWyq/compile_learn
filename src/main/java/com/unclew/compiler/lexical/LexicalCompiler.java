package com.unclew.compiler.lexical;

import com.unclew.compiler.lexical.statemachine.FiniteStateMachine;

/**
 * Created by wuyingqiang
 * on 2020/4/5-1:08 下午.
 * <p>
 * 词法分析程序
 * <p>
 * 分析
 * int age; // 定义变量
 * age = 46; // 赋值
 * 2 + 3 * 5; // 表达式 + - * /
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class LexicalCompiler {
    private FiniteStateMachine lexicalMachine;

    public LexicalCompiler(String str) {
        SimpleILetterMachine sim = new SimpleILetterMachine(str);
        lexicalMachine = new FiniteStateMachine(sim);
    }

    public SimpleTokenMachine parsing() {
        return lexicalMachine.parsing();
    }

    public static void main(String[] args) {
        String str = "int age; age = 46; 2 + 3 * 56; age > 30; age >= 40;";
        LexicalCompiler lexicalCompiler = new LexicalCompiler(str);
        SimpleTokenMachine tokenMachine = lexicalCompiler.parsing();
        System.out.println();
        System.out.println(tokenMachine);
    }
}
