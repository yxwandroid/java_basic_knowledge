package com.wilson.java.collection_demo;

import java.util.HashSet;
import java.util.Set;

/**
 * HashCode经常用于确定对象的存储地址
 */
public class HashDemo {


    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof HashDemo)) {
            return false;
        }
        HashDemo other = (HashDemo) object;
        if (other.getI() == this.getI()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return i % 10;
    }

    public final static void main(String[] args) {
        HashDemo a = new HashDemo();
        HashDemo b = new HashDemo();
        a.setI(1);
        b.setI(1);
        Set<HashDemo> set = new HashSet<HashDemo>();
        set.add(a);
        set.add(b);
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(set);
    }

}

