package com.tot.util;

import com.tot.data.DemoData2;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FieldUtilTest {

    @Test
    public void getFiledName() {
        Set<String> fields = FieldUtil.getFiledName(new DemoData2());
        HashSet<Object> expectSet = new HashSet<>();
        expectSet.add("id2");
        expectSet.add("id");
        expectSet.add("name");
        expectSet.add("price");
        expectSet.add("createTime");
        System.out.println(fields);
        Assert.assertEquals(fields,expectSet);
    }

    @Test
    public void getFieldValueByName() {
        DemoData2 demoData2 = new DemoData2();
        demoData2.setId2(12L);
        demoData2.setId(10L);
        demoData2.setCreateTime(LocalDateTime.of(2020,7,29,17,10,50));
        demoData2.setPrice(0.01D);
        Assert.assertEquals(12L,FieldUtil.getFieldValueByName("id2",demoData2));
        Assert.assertEquals(10L,FieldUtil.getFieldValueByName("id",demoData2));
        Assert.assertEquals(LocalDateTime.of(2020,7,29,17,10,50),
                FieldUtil.getFieldValueByName("createTime",demoData2));
        Assert.assertEquals(0.01D,FieldUtil.getFieldValueByName("price",demoData2));
    }
}