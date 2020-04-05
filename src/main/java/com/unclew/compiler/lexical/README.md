### 词法分析 - 难度不大，容易实现

**词法分析，将字符变成词法单位块的过程**

> 词法分析主要还是需要根据词法规则构建一个 `有限自动状态机(FSM)`

#### 词法分析前的工作(before lexical)

> 1. 构建每一个 Token 的规则，最好是 `正则表达式`；
> 2. 画出词法规则的`有限自动机`，辅助实现；

#### 词法分析后的结果(after lexical)

> 词法分析之后，结果应该是 Token 的一个有序集合（相当于 `单词` 的集合）

#### 词法分析中可以被优化的可能(效率)

1. 字符序列读取的数量，有些时候因为回溯会导致字符读取的次数大于字符本身的数量
2. 如何简化代码状态转换的可读性