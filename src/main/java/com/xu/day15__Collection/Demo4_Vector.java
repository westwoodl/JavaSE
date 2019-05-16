package com.xu.day15__Collection;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 被淘汰的老员工，只在面试的时候用
 * @deprecated
 */
public class Demo4_Vector {
    Vector v;


    @Test
    public void hha(){
        v = new Vector();
        v.add("a");
        v.add("a");
        v.add("a");
        v.add("a");

        Enumeration e = v.elements();
        while (e.hasMoreElements())
            System.out.println(e.nextElement());
    }
}
