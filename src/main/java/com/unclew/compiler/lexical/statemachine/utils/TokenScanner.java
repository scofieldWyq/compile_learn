package com.unclew.compiler.lexical.statemachine.utils;

/**
 * Created by wuyingqiang
 * on 2020/4/12-5:00 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public interface TokenScanner<T> {
    T peek(); // 预读当前字符
    T read(); // 读取当前字符
    void unset(); // 回退一个字符
    void unset(int offset); // 回退 offset 个字符
    void reset(); //
}
