package com.unclew.compiler.grammar;

import com.unclew.compiler.grammar.common.ASTType;
import com.unclew.compiler.lexical.common.State;
import com.unclew.compiler.lexical.common.Token;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuyingqiang
 * on 2020/4/5-6:23 下午.
 * <p>
 * 抽象语法树节点，每一个 AST 节点都是一个可计算的节点
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class ASTNode {
    private State type;
    private String text;
    private List<ASTNode> nodes = new LinkedList<ASTNode>();

    public ASTNode(Token token) {
        type = token.getState();
        text = token.getText();
    }

    public void addNode(ASTNode node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return recursiveStr(this, 0);
    }

    private String nodeInfo() {
        return "ASTNode{" +
                "type=" + type +
                ", text='" + text + '\'' +
                "}";
    }
    private String recursiveStr(ASTNode node, int level) {
        StringBuilder strBuilder = new StringBuilder();
        for(int i =0 ; i < level; i++) {
            strBuilder.append("\t");
        }

        strBuilder.append(node.nodeInfo());
        strBuilder.append("\n");

        if(nodes.size() > 0) {
            for(ASTNode n: node.nodes) {
                strBuilder.append(recursiveStr(n, level + 1));
            }
        }

        return strBuilder.toString();
    }
}
