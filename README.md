# READ_ME
## 功能
- 支持：EQ, NOT_EQ, LIKE, NOT_LIKE, GT, LT, GTE, LTE, IS_NULL, NOT_NULL, IN, NOT_IN;等条件过滤
- 支持分组过滤，但目前支持一层的分组，即： （）and/or (),组内的过滤规则和mysql一致，AND运算优先于OR运算
- 支持分组，并支持多个属性
- 支持排序，并支持多个属性不同方向（ASC/DESC）排序
- 支持LIMIT限制输出内容，逻辑稍微和mysql不太一样。

## 未完待续
- 数据某些类别的字段可能不支持所有的过滤操作，这个校验过程目前也在过滤中完成。后续可以考虑在构建Where对象时校验。


