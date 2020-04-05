package com.unclew.compiler.lexical;

/**
 * Created by wuyingqiang
 * on 2020/4/5-12:07 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class SimpleILetterMachine implements ItemScanningFactory<Character> {
    private String items;
    private int currentIndex = 0;

    public SimpleILetterMachine(String str) {
        this.items = str;
    }

    public Character preview() {
        if(currentIndex == items.length()) {
            return null;
        }

        return items.charAt(currentIndex);
    }

    public void read() {
        if(currentIndex < items.length())
            currentIndex++;
    }

    public void unread() {
        if(currentIndex > 0) {
            currentIndex--;
        }
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
        return currentIndex == items.length();
    }
}
