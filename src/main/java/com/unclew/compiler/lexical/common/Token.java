package com.unclew.compiler.lexical.common;

/**
 * Created by wuyingqiang
 * on 2020/4/5-1:10 下午.
 * <p>
 * 词法 Token
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class Token {
    private State state;
    private StringBuilder strBuilder = new StringBuilder();

    public Token(char c, State initState) {
        strBuilder.append(c);
        state = initState;
    }

    public void append(char c) {
        strBuilder.append(c);
    }

    public void changeState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "\nToken{" +
                "type=" + state +
                ", text=\'" + strBuilder + "\'" +
                "}";
    }
}
