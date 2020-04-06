package com.unclew.compiler.grammar.common;

/**
 * Created by wuyingqiang
 * on 2020/4/6-11:02 下午.
 *
 * 抽象语法树节点的接口
 *
 * @author wuyingqiang
 * @since 1.0
 */
public interface AST {
    void execute();
    void add(AST ast);
}
