package com.unclew.compiler.lexical.statemachine;

/**
 * Created by wuyingqiang
 * on 2020/4/5-1:12 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public enum State {
    Init, // 初始化
    Identifier, // 标识符
    Digit, // 数字
    GT,
    GE,
    EQ,
    Int, // 整型
    Int_0,
    Int_1,
    End, // ; 语句结束符
    Plus, // +
    Min, // -
    Mul, // *
    Div, // /
}
