package com.unclew.compiler.lexical.statemachine;

import com.unclew.compiler.lexical.common.FiniteState;
import com.unclew.compiler.lexical.common.FiniteToken;
import com.unclew.compiler.lexical.common.TokenType;
import com.unclew.compiler.lexical.statemachine.utils.SimpleTokenScanner;
import com.unclew.compiler.lexical.statemachine.utils.TokenScanner;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuyingqiang
 * on 2020/4/12-5:49 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class FiniteStateMachine2 {
    private TokenScanner<Character> tokenScanner;
    private List<FiniteToken> tokens;

    public void setSequence(String seq) {
        tokenScanner = new SimpleTokenScanner(seq);
        tokens = new LinkedList<>();
    }

    // 词法分析有限状态机
    public void parsing() {

        FiniteState state = FiniteState.Init;
        FiniteToken token = null;

        Character c = null;
        boolean hasTokenCatch = false;

        while ((c = tokenScanner.peek()) != null) {
            switch (state) {
                case Init:
                    if (isDigit(c)) { // 检查是否是数字
                        state = FiniteState.Digit_1;
                        c = tokenScanner.read();
                        token = new FiniteToken(c, TokenType.Digit);
                    } else if(c == ';') {
                        state = FiniteState.End;
                        c = tokenScanner.read();
                        token = new FiniteToken(c, TokenType.End);
                    } else if(c == '=') {
                        state = FiniteState.Assignment;
                        c = tokenScanner.read();
                        token = new FiniteToken(c, TokenType.Assignment);
                    }
                    break;
                case Digit_1:
                    if (isDigit(c)) {
                        c = tokenScanner.read();
                        token.add(c);
                    } else if (c == '.') {
                        state = FiniteState.Digit_2;
                        c = tokenScanner.read();
                        token.add(c);
                    } else {
                        // return  to init
                        hasTokenCatch = true;
                        state = FiniteState.Init;
                    }

                    break;
                case Digit_2:
                    if (isDigit(c)) {
                        c = tokenScanner.read();
                        token.add(c);
                    } else {
                        hasTokenCatch = true;
                        state = FiniteState.Init;
                    }
                    break;
                case End:
                    hasTokenCatch = true;
                    state = FiniteState.Init;
                    break;
                case Assignment:
                    if(c == '=') {
                        state = FiniteState.Equal;
                        token.changeType(TokenType.Equal);
                        c = tokenScanner.read();
                        token.add(c);
                    } else {
                        hasTokenCatch = true;
                        state = FiniteState.Init;
                    }
                    break;
                case Equal:
                    hasTokenCatch = true;
                    state = FiniteState.Init;
                    break;
            }

            if (hasTokenCatch && token != null) {
                tokens.add(token);
                hasTokenCatch = false;
                token = null;
            }
        }

        if(token != null) {
            tokens.add(token);
        }
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public FiniteToken get(int index) {
        if(index < tokens.size() && index >= 0) {
            return tokens.get(index);
        }

        return null;
    }

    @Override
    public String toString() {
        return "tokens{" + tokens + "}";
    }
}
