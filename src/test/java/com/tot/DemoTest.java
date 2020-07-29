package com.tot;

import com.tot.data.DemoData1;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DemoTest {

    @org.junit.Test
    public void query() {
        Demo demo = new Demo();
        DemoData1 data1 = new DemoData1();
        List<DemoData1> demoData1s = new ArrayList<>();
        demoData1s.add(data1);
        demo.query(demoData1s,null,null,null,null);

    }

    @Test
    public void strCompareTest(){
        String str1 = "abch";
        String str2 = "abcga21515";
        System.out.print(str1.compareTo(str2));
    }
}