package com.tot;

import com.tot.data.DemoData1;
import com.tot.query.Where;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DemoTest {

    @Test
    public void testGroupCriteria() {
        SqlLikeQuery demo = new SqlLikeQuery();
        Where where = Where.newInstance();
        where.init()
            .andEqual("id",2L);
        // id = 3 and id = 2 or id=2 or id=3 and id=2
        where.andGroup()
                .andEqual("id",3L)
                .andEqual("id",2L)
                .orEqual("id",2)
                .orEqual("id",3L)
                .andEqual("id",2L);
        List<DemoData1> rst = demo.query(testData(), where, null, null, null);
        System.out.println(rst);
        Assert.assertEquals(0,rst.size());

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
        data2.setName("aaaa");
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