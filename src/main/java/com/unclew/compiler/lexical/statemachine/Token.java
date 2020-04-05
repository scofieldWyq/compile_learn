package com.unclew.compiler.lexical.statemachine;

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

    void append(char c) {
        strBuilder.append(c);
    }

    void changeState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Token{" +
                "state=" + state +
                ", strBuilder=\'" + strBuilder + "\'" +
                '}';
    }
}
