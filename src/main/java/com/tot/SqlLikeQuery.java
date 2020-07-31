package com.tot;

import com.tot.query.GroupBy;
import com.tot.query.Limit;
import com.tot.query.OrderBy;
import com.tot.query.Where;
import com.tot.query.ext.WhereHandler;
import com.tot.util.FieldUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 数学上的与非运算-参考资料：
 * https://wenku.baidu.com/view/d30c60bb185f312b3169a45177232f60ddcce72f.html
 *
 * 用Java实现一个类似SQL查询的服务，参数模型自己设计：
 *  入参：
 *   - 类比某张表内全量数据
 *   - 过滤条件，支持多个，与/或
 *   - 排序，支持多个，以及升序倒序
 *   - 分组，支持多个
 *   - 最大返回结果数
 *  返回：
 *   - 查询结果
 *
 * 大概这样：
 *
 *     List<Object> query(List<Object> data, Where where, OrderBy orderBy, GroupBy groupBy, Limit limit) {
 *         //你的代码实现。。。
 *     }
 *
 *
 * 作业要求：
 *  1. 在个人github上新建一个工程，完成后提交该项目的URL
 *  2. 需要包含测试代码
 *  3. 自由发挥，重点展现自己代码功底，包括不限于 可读性/可测性/可维护性/性能等等。有些细节如果时间紧张可以封装甚至MOCK掉。
 *  4. 时间要求：3日内
 */
public class SqlLikeQuery {

    private final WhereHandler whereHandler = new WhereHandler();

     public <T> List<T> query(List<T> data, Where where, OrderBy orderBy, GroupBy groupBy, Limit limit) {
         //你的代码实现。。。
         assert data != null;
         if (data.size() == 0) {
             return data;
         }
         data = whereFilter(data,where);
         data = group(data,groupBy);
         data = order(data,orderBy);
         return limit(data,limit);
     }

    /**
     * limit 处理
     * @param data
     * @param limit
     * @param <T>
     * @return
     */
    private <T> List<T> limit(List<T> data, Limit limit) {
        if (limit == null) {
            return data;
        }
        limit.check();
        int dataSize = data.size();
        if (dataSize == 0) {
            return data;
        }
        int from = 0;
        int end = dataSize;
        if(limit.getFrom() != null){
            if(limit.getFrom() >= dataSize ){
                return new ArrayList<>();
            } else {
                from = limit.getFrom();
            }
        }
        if(limit.getCount() != null){
            end = Math.min(end,from + limit.getCount());
        }
        return data.subList(from,end);
    }

    /**
     * 排序处理
     * @param data
     * @param orderBy
     * @param <T>
     * @return
     */
    private <T> List<T> order(List<T> data, OrderBy orderBy) {
        if (orderBy == null  || orderBy.getBy() == null || orderBy.getBy().size() == 0) {
            return data;
        }
        data.sort((v1,v2)->{
            int rst = 0;
            for (OrderBy.OrderItem orderItem : orderBy.getBy()) {
                String colName = orderItem.getColName();
                Object colV1 = FieldUtil.getFieldValueByName(colName, v1);
                if(!(colV1 instanceof Comparable)){
                    throw new IllegalStateException(String.format("col[%s] must be Comparable",colName));
                }
                Object colV2 = FieldUtil.getFieldValueByName(colName, v2);
                if(orderItem.getType().equals(OrderBy.OrderType.ASC)){
                    rst = ((Comparable) colV1).compareTo(colV2);
                } else {
                    rst = 0 - ((Comparable) colV1).compareTo(colV2);
                }
                if(rst != 0 ){
                   return rst;
                }

            }
            return rst;
        });
        return data;
    }

    /**
     * 分组处理
     * @param data
     * @param groupBy
     * @param <T>
     * @return
     */
    private <T> List<T> group(List<T> data, GroupBy groupBy) {
        if (groupBy == null || groupBy.getCols() == null || groupBy.getCols().size() == 0) {
            return data;
        }
        // linkedMap记录插入顺序

        Map<List<Object>, T> groupMap = new LinkedHashMap<>();
        for (T row : data) {
            List<Object> identifyKey = groupBy.getCols().stream().map(v->{
                Object fValue = FieldUtil.getFieldValueByName(v, row);
                return fValue == null ? "NONE":fValue;
            }).collect(Collectors.toList());
            groupMap.putIfAbsent(identifyKey, row);
        }
        return new ArrayList<>(groupMap.values());
    }

    /**
     * 条件过滤。由于数据是用户通过接口传递，因此这里没有必要加索引，直接遍历就行了
     * @param dataList
     * @param where
     * @param <T>
     * @return
     */
    private <T> List<T> whereFilter(List<T> dataList, Where where) {
        if (where == null || where.getCriteriaGroups() == null || where.getCriteriaGroups().size() == 0) {
            return dataList;
        }
        //
        List<T> rstList = new ArrayList<>();
        for (T row  : dataList) {
            // 过滤处理
            boolean match = whereHandler.isMatch(row,where);
            if (match) {
                rstList.add(row);
            }
        }
        return rstList;
    }
}
