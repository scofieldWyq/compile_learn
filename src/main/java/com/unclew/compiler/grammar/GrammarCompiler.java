package com.unclew.compiler.grammar;

import com.unclew.compiler.grammar.common.AST;
import com.unclew.compiler.grammar.common.ASTType;
import com.unclew.compiler.grammar.utils.SimpleTokenMachine;
import com.unclew.compiler.lexical.common.State;
import com.unclew.compiler.lexical.common.Token;

/**
 * Created by wuyingqiang
 * on 2020/4/5-6:15 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class GrammarCompiler {

    // 定义 Int
    // int <identifier> (= add);
    public AST intDeclaration(SimpleTokenMachine stm) throws Exception {
        // 解析 "定义int变量"
        // intDeclaration := int identifier;
        AST root = null;
        AST node1 = null;
        AST node2 = null;

        int count = 0;
        Token t = stm.preview();
        if(t != null && t.getState() == State.Int) {
            stm.read();
            count++;
            t = stm.preview();

            if (t != null && t.getState() == State.Identifier) {
                root = new AST(t.getText(), ASTType.IntDeclaration);
                stm.read();
                count++;
                t = stm.preview();

                if (t != null && t.getState() == State.EQ) {
                    node1 = new AST(t.getText(), ASTType.Assignment);
                    stm.read();
                    count++;
                    node2 = expression(stm);
                    if(node2 == null) {
                        stm.unread(count);
                        throw new Exception("assignment error: no right expression to assign to left.");
                    } else {
                        node1.addChild(node2);
                        root.addChild(node1);
                    }
                } else if (t != null && t.getState() == State.End) {
                    stm.read();
                }
            } else {
                stm.unread(count);
                throw new Exception("int declaration error: no variable to declare");
            }
        }

        return root;
    }

    // 直接返回数值
    public AST expression(SimpleTokenMachine stm){
        AST root = null;
        int count = 0;

        Token t = stm.preview();
        if(t != null && t.getState() == State.Digit) {
            root = new AST(t.getText(), ASTType.Digit);
            stm.read();
        }

        return root;
    }

    public void parsing() {
        // TODO 解析语法 - 暂时解析
        //  1. 定义int变量
        //  2. int 变量赋值
        //  3. +、-、*、/ 的表达式
        //  4. 比较符号
        //  主要使用递归下降算法处理
        // int age; age = 46; 2 + 3 * 56; age > 30; age >= 40;

    }

}
