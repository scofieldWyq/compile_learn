package com.unclew.compiler.grammar.common;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuyingqiang
 * on 2020/4/6-11:04 下午.
 *
 * Int 定义的语法规则
 *
 * 定义一个 Int 变量
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class IntDeclarationAST extends AST {
    private List<AST> children = null;

    public IntDeclarationAST(String text) {
        super(text, ASTType.IntDeclaration);
    }

    public void execute(AST parent) {
        // 执行计算过程
    }

    public void add(AST ast) {
        if(children == null) {
            children = new LinkedList<AST>();
        }

        children.add(ast);
    }
}
