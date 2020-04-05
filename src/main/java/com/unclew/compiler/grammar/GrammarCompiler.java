package com.unclew.compiler.grammar;

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
    public ASTNode intDeclaration(SimpleTokenMachine stm) throws Exception {
        // 解析 "定义int变量"
        // intDeclaration := int identifier;
        ASTNode root = null;
        ASTNode node1 = null;
        ASTNode node2 = null;

        int count = 0;

        Token t = stm.preview();
        if(t != null && t.getState() == State.Int) {
            root = new ASTNode(t);
            node1 = root;
            stm.read();
            count++;
            t = stm.preview();

            if(t != null && t.getState() == State.Identifier) {
                node2 = new ASTNode(t);
                node1.addNode(node2);
                node1 = node2;

                stm.read();
                count++;
                t = stm.preview();

                if(t != null && t.getState() == State.End) {
                    // end here.
                    node2 = new ASTNode(t);
                    node1.addNode(node2);
                    stm.read();
                    return root;
                }

                stm.unread(count);
                throw new Exception("syntax error here: no ';' for end");

            } else {
                stm.unread(count);
                throw new Exception("syntax error here: " + t);
            }
        } else {
            return null;
        }
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
