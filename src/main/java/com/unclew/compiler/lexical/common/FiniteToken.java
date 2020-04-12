package com.unclew.compiler.lexical.common;

/**
 * Created by wuyingqiang
 * on 2020/4/12-6:08 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class FiniteToken {
    private final StringBuilder strBuilder = new StringBuilder();
    private TokenType type;

    public FiniteToken(char c, TokenType type) {
        strBuilder.append(c);
        this.type = type;
    }

    public void add(char c) {
        strBuilder.append(c);
    }

    public void changeType(TokenType t) {
        type = t;
    }

    public String text() {
        return strBuilder.toString();
    }

    @Override
    public String toString() {
        return "{" + type + ":" + text() + "}";
    }
}
