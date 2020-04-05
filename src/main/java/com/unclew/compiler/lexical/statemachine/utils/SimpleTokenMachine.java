package com.unclew.compiler.lexical.statemachine.utils;

import com.unclew.compiler.lexical.common.Token;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuyingqiang
 * on 2020/4/5-1:23 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class SimpleTokenMachine implements ItemScanningFactory<Token> {
    private List<Token> tokens = new LinkedList<Token>();
    private int currentIndex = 0;

    public SimpleTokenMachine() {

    }

    public Token preview() {
        if (currentIndex == tokens.size()) {
            return null;
        }

        return tokens.get(currentIndex);
    }

    public void read() {
        if (currentIndex < tokens.size())
            currentIndex++;
    }

    public void unread() {
        if (currentIndex > 0)
            currentIndex--;
    }

    public void unread(int backOffSet) {
        while (backOffSet > 0) {
            backOffSet--;
            unread();
        }
    }

    public void reset() {
        currentIndex = 0;
    }

    public boolean isTail() {
        return currentIndex == tokens.size();
    }

    public String tokens() {
        return String.format("%s", this.tokens);
    }

    public void addToken(Token t) {
        this.tokens.add(t);
    }

    @Override
    public String toString() {
        return "SimpleTokenMachine{" +
                "\ntokens=[" + tokens +
                "]\nsize=" + tokens.size() +
                "\n}";
    }
}
