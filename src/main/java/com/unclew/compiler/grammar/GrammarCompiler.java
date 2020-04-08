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
                    node2 = addExpression(stm);
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

    /**
     * 表达式
     *
     * add := add + mul | mul
     * mul := mul * pri | pri
     * pri := Identifier | Digit | (add)
     *
     * add  := mul add'
     * add' := +mul add'
     *
     * -> add := mul (+ mul)*
     *
     * mul  := pri mul'
     * mul' := *pri mul'
     *
     * -> mul := pri (*pri)*
     *
     *
     * @param stm
     * @return
     */
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

    public AST addExpression(SimpleTokenMachine stm) throws Exception {
        // add := mul (+ mul)*

        AST root = null;
        AST mul = mulExpression(stm);
        AST node2 = null;

        if(mul != null) {
            while(true) {

                Token t = stm.preview();
                if(t != null && t.getState() == State.Plus) {
                    stm.read();
                    root = new AST(t.getText(), ASTType.Add);

                    node2 = mulExpression(stm);

                    if(node2 != null) {
                        root.addChild(mul);
                        root.addChild(node2);
                        mul = root;
                    } else {
                        throw new Exception("plus no right expression");
                    }
                } else {
                    break;
                }
            }

        }

        return mul;
    }

    public AST mulExpression(SimpleTokenMachine stm) throws Exception {
        // mul := pri (*pri)*
        AST root = null;
        AST pri = null;
        AST node2 = null;

        pri = priExpression(stm);
        if(pri != null){
            Token t = null;

            while(true) {
                t = stm.preview();
                if(t != null && t.getState() == State.Mul) {
                    stm.read();
                    node2 = priExpression(stm);
                    if(node2 != null) {
                        root = new AST(t.getText(), ASTType.Mul);
                        root.addChild(pri);
                        root.addChild(node2);
                        pri = root;
                    } else {
                        throw new Exception("mul no right pri");
                    }
                } else {
                    break;
                }
            }
        }

        return pri;
    }

    public AST priExpression(SimpleTokenMachine stm) {
        // pri := Identifier | Digit
        Token t = stm.preview();


        if(t != null) {
            ASTType type = null;

            switch (t.getState()) {
                case Identifier:
                    type = ASTType.Indentifier;
                    break;
                case Digit:
                    type = ASTType.Digit;
                    break;
            }

            if(type != null) {
                stm.read();
                return new AST(t.getText(), type);
            }
        }

        return null;
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
