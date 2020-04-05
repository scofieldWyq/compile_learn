package com.unclew.compiler.lexical.statemachine;

import com.unclew.compiler.lexical.common.State;
import com.unclew.compiler.lexical.common.Token;
import com.unclew.compiler.lexical.statemachine.utils.ItemScanningFactory;
import com.unclew.compiler.lexical.statemachine.utils.SimpleTokenMachine;

/**
 * Created by wuyingqiang
 * on 2020/4/5-1:11 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class FiniteStateMachine {

    private ItemScanningFactory<Character> letterFactory;

    public FiniteStateMachine(ItemScanningFactory<Character> factory) {
        this.letterFactory = factory;
    }

    public SimpleTokenMachine parsing() {
        // TODO 词法分析 - lexical analysis
        SimpleTokenMachine stm = new SimpleTokenMachine();
        State currentState = State.Init;
        Token t = null;

        while (!letterFactory.isTail()) {
            char c = letterFactory.preview();
            System.out.print(c);
            switch (currentState) {
                case Init: // 开始状态
                    if (c == 'i') {
                        currentState = State.Int_0;
                        t = new Token(c, State.Int);
                    } else if (isAlpha(c)) {
                        currentState = State.Identifier;
                        t = new Token(c, currentState);
                    } else if (isDigit(c)) {
                        currentState = State.Digit;
                        t = new Token(c, currentState);
                    } else if (c == '>') {
                        currentState = State.GT;
                        t = new Token(c, currentState);
                    } else if (c == '+') {
                        currentState = State.Plus;
                        t = new Token(c, currentState);
                    } else if (c == '-') {
                        currentState = State.Min;
                        t = new Token(c, currentState);
                    } else if (c == '*') {
                        currentState = State.Mul;
                        t = new Token(c, currentState);
                    } else if (c == '/') {
                        currentState = State.Div;
                        t = new Token(c, currentState);
                    } else if (c == ';') {
                        currentState = State.End;
                        t = new Token(c, currentState);
                    } else if (c == '=') {
                        currentState = State.EQ;
                        t = new Token(c, currentState);
                    }

                    letterFactory.read();

                    break;
                case Int_0:
                    if (c == 'n') {
                        currentState = State.Int_1;
                        t.append(c);
                        letterFactory.read();
                    } else if (isAlpha(c) || isDigit(c)) {
                        currentState = State.Identifier;
                        t.append(c);
                        t.changeState(currentState);
                        letterFactory.read();
                    } else {
                        currentState = State.Init;
                    }
                    break;
                case Int_1:
                    if (c == 't') {
                        currentState = State.Int;
                        t.append(c);
                        letterFactory.read();
                    } else if (isAlpha(c) || isDigit(c)) {
                        currentState = State.Identifier;
                        t.append(c);
                        t.changeState(currentState);
                        letterFactory.read();
                    } else {
                        currentState = State.Init;
                    }
                    break;
                case Int:
                    if (isAlpha(c) || isDigit(c)) {
                        currentState = State.Identifier;
                        t.append(c);
                        t.changeState(currentState);
                        letterFactory.read();
                    } else {
                        currentState = State.Init;
                    }
                    break;
                case Identifier:
                    if (isAlpha(c) || isDigit(c)) {
                        t.append(c);
                        letterFactory.read();
                    } else {
                        currentState = State.Init;
                    }

                    break;
                case Digit:
                    if (isDigit(c)) {
                        t.append(c);
                        letterFactory.read();
                    } else {
                        currentState = State.Init;
                    }
                    break;
                case GT:
                    if (c == '=') {
                        t.append(c);
                        currentState = State.GE;
                        t.changeState(currentState);
                        letterFactory.read();
                    } else {
                        currentState = State.Init;
                    }
                    break;
                default:
                    currentState = State.Init;
            }

            if (currentState == State.Init && t != null) {
                stm.addToken(t);
                t = null;

                if(c == ';') {
                    letterFactory.read();
                    stm.addToken(new Token(c, State.End));
                }
            }
        }

        return stm;
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
