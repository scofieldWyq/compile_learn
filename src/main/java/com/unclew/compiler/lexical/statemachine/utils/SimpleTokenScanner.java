package com.unclew.compiler.lexical.statemachine.utils;

/**
 * Created by wuyingqiang
 * on 2020/4/12-5:02 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class SimpleTokenScanner implements TokenScanner<Character> {
    private String tokenSequence = "";
    private int cursor = 0;

    public SimpleTokenScanner(String str) {
        this.tokenSequence = str;
    }

    @Override
    public Character peek() {
        if(cursor >= tokenSequence.length()) {
            return null;
        }

        return tokenSequence.charAt(cursor);
    }

    @Override
    public Character read() {
        if(cursor >= tokenSequence.length()) {
            return null;
        }

        return tokenSequence.charAt(cursor++);
    }

    @Override
    public void unset() {
        if(cursor > 0)
            cursor--;
    }

    @Override
    public void unset(int offset) {
        if(cursor - offset > 0) {
            cursor -= offset;
        } else {
            cursor = 0;
        }
    }

    @Override
    public void reset() {
        cursor = 0;
    }
}
