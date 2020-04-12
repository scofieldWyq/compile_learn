package com.unclew.compiler.lexical.statemachine.utils;

/**
 * Created by wuyingqiang
 * on 2020/4/5-12:05 下午.
 *
 * 提供一个连续的项目内容的管理
 *
 * @author wuyingqiang
 * @since 1.0
 */
public interface ItemScanningFactory<T> {
    T preview(); // 预读当前项目
    void read(); // 下一个项目
    void unread(); // 回退到上一个项目
    void unread(int backOffSet); // 回退到 backOffSet 距离的项目
    void reset(); // 重置
    boolean isTail(); // 是否最后了
}
