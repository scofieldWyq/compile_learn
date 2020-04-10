package com.unclew.compiler.lexical.common;

/**
 * Created by wuyingqiang
 * on 2020/4/10-10:46 下午.
 *
 * 定义各种 Token 的类型和规则(Regular)
 *
 * 定义简单的可以执行计算的 Token，同时支持变量存储，支持多种类型数据
 *
 * @author wuyingqiang
 * @since 1.0
 */
public enum TokenType {
    Identifier, // 标识符， [a-zA-Z_]([0-9]|[a-zA-Z_])*
    Digit, // 数字，[1-9]([0-9]*|\.)[0-9]*
    End, // 结束 ;
    // 比较相关
    Equal, // 等于 ==
    NotEqual, // 不等于 !=
    GT, // >
    GE, // >=
    LT, // <
    LE, // <=
    // 条件相关
    And, // &&
    Or, // ||
    Not, // !
    // 赋值相关
    Assignment, // 赋值 =
    PlusAssignment, // +=
    MinusAssignment, // -=
    MulAssignment, // *=
    DivAssignment, // /=
    ModAssignment, // %=
    // 计算相关
    Plus, // +
    SelfPlus, // ++
    Minus, // -
    SelfMinus, // --
    Mul, // *
    Div, // /
    Mod, // %
    // 括号
    LeftBrace, // (
    RightBrace, // )
    // 可计算类型
    Byte, // byte
    Short, // short
    Int, // int
    Long, // long
    Char, // char
    Float, // float
    Double, // double
    Bool, // bool
}
