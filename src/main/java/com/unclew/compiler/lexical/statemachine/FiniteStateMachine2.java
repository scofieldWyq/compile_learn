package com.unclew.compiler.lexical.statemachine;

import com.unclew.compiler.lexical.common.Token;
import com.unclew.compiler.lexical.statemachine.utils.SimpleTokenScanner;
import com.unclew.compiler.lexical.statemachine.utils.TokenScanner;

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
    private List<Token> tokens;

    public FiniteStateMachine2(String sequence) {
        tokenScanner = new SimpleTokenScanner(sequence);
    }

    // 词法分析有限状态机
    public void parsing(){

    }

}
