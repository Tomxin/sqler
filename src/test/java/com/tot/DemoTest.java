package com.tot;

import com.tot.data.DemoData1;
import com.tot.query.GroupBy;
import com.tot.query.Limit;
import com.tot.query.OrderBy;
import com.tot.query.Where;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class DemoTest {

    @Test
    public void testGroupCriteria() {
        SqlLikeQuery demo = new SqlLikeQuery();
        Where where = Where.newInstance();
        // (id=2 ) and ( id = 3 and id = 2 or id=2 or id=3 and id=2)

        where.init()
            .andEqual("id",2L);
        where.andGroup()
                .andEqual("id",3L)
                .andEqual("id",2L)
                .orEqual("id",2L)// id=2 ===> 整个group为true
                .orEqual("id",3L)
                .andEqual("id",2L);
        List<DemoData1> rst = demo.query(testData(), where, null, null, null);
        System.out.println(rst);
        Assert.assertEquals(1,rst.size());
    }

    @Test
    public void testEq() {
        SqlLikeQuery demo = new SqlLikeQuery();
        Where where = Where.newInstance();
        where.init()
                .andEqual("name","abc");
        List<DemoData1> rst = demo.query(testData(), where, null, null, null);
        System.out.println(rst);
        Assert.assertEquals(2,rst.size());
    }

    @Test
    public void testLike() {
        SqlLikeQuery demo = new SqlLikeQuery();
        Where where = Where.newInstance();
        where.init()
                .andLike("name","abc");
        List<DemoData1> rst = demo.query(testData(), where, null, null, null);
        System.out.println(rst);
        Assert.assertEquals(3,rst.size());
    }

    @Test
    public void testGreatThan() {
        SqlLikeQuery demo = new SqlLikeQuery();
        Where where = Where.newInstance();
        where.init()
                .andGreaterThan("id",1L);
        List<DemoData1> rst = demo.query(testData(), where, null, null, null);
        System.out.println(rst);
        Assert.assertEquals(2,rst.size());
    }

    @Test
    public void testIn(){
        SqlLikeQuery demo = new SqlLikeQuery();
        Where where = Where.newInstance();
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(3L);
        where.init()
                .andIn("id", ids);
        List<DemoData1> rst = demo.query(testData(), where, null, null, null);
        System.out.println(rst);
        Assert.assertEquals(2,rst.size());
    }

    @Test
    public void testSort(){
        SqlLikeQuery demo = new SqlLikeQuery();

        List<OrderBy.OrderItem> orderItemList = new ArrayList<>();
        OrderBy.OrderItem orderItem = new OrderBy.OrderItem();
        orderItem.setColName("id");
        orderItem.setType(OrderBy.OrderType.DESC);
        orderItemList.add(orderItem);
        OrderBy orderBy = new OrderBy();
        orderBy.setBy(orderItemList);
        List<DemoData1> rst = demo.query(testData(), null,orderBy, null, null);
        System.out.println(rst);

        Assert.assertEquals(3L,rst.size());
        Assert.assertEquals(1L,rst.get(2).getId().longValue());
    }


    @Test
    public void testGroup(){
        SqlLikeQuery demo = new SqlLikeQuery();

        GroupBy groupBy = new GroupBy();
        HashSet<String> colSet = new HashSet<>();
        colSet.add("name");
        groupBy.setCols(colSet);
        List<DemoData1> rst = demo.query(testData(), null,null, groupBy, null);
        System.out.println(rst);

        Assert.assertEquals(2,rst.size());
    }

    @Test
    public void testLimiter(){
        SqlLikeQuery demo = new SqlLikeQuery();

        Limit limit = new Limit();
        limit.setFrom(1);
        limit.setCount(10);
        List<DemoData1> rst = demo.query(testData(), null,null, null, limit);
        System.out.println(rst);

        Assert.assertEquals(2,rst.size());
    }




    public List<DemoData1> testData(){
        List<DemoData1> demoData1s = new ArrayList<>();
        DemoData1 data1 = new DemoData1();
        data1.setId(1L);
        data1.setName("abc");
        data1.setPrice(10d);
        data1.setCreateTime(LocalDateTime.of(2020,1,1,12,30,30));
        demoData1s.add(data1);

        DemoData1 data2 = new DemoData1();
        data2.setId(2L);
        data2.setName("abc");
        data2.setPrice(16d);
        data2.setCreateTime(LocalDateTime.of(2020,2,1,12,30,30));
        demoData1s.add(data2);

        DemoData1 data3 = new DemoData1();
        data3.setId(3L);
        data3.setName("abcd");
        data3.setPrice(6d);
        data3.setCreateTime(LocalDateTime.of(2010,2,1,12,30,30));
        demoData1s.add(data3);
        return demoData1s;
    }

    @Test
    public void strCompareTest(){
        String str1 = "abch";
        String str2 = "abcga21515";
        System.out.print(str1.compareTo(str2));
    }
}