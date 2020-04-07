package com.unclew.compiler.grammar.common;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuyingqiang
 * on 2020/4/6-11:02 下午.
 * <p>
 * 抽象语法树节点
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class AST {
    private ASTType type;
    private String value;
    private List<AST> children;

    public AST(String value, ASTType type) {
        this.value = value;
        this.type = type;
        children = new LinkedList<AST>();
    }

    public void addChild(AST ast) {
        children.add(ast);
    }

    public ASTType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public AST getChild(int num) {
        if (num < 0 || num >= children.size()) {
            return null;
        }

        return children.get(num);
    }

    private String info() {
        return type + "[" + value + ']';
    }

    @Override
    public String toString() {
        return info(1);
    }

    public String info(int level) {
        final StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(this.info());

        this.children.forEach(child -> {
            strBuilder.append("\n");

            for (int i = 0; i < level; i++) {
                strBuilder.append("\t");
            }

            strBuilder.append(child.info(level+1));
        });

        return strBuilder.toString();
    }
}
