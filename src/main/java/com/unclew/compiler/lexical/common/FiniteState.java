package com.unclew.compiler.lexical.common;

/**
 * Created by wuyingqiang
 * on 2020/4/12-5:59 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public enum FiniteState {
    Init,
    Digit_1,
    Digit_2,
    Assignment,
    Equal,
    Identifier,
    End,
    GT,
    GE,
    LT,
    LE,
    And_1,
    And,
    Or_1,
    Or,
    Not_1,
    Not,
}
