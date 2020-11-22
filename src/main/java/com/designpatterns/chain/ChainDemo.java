package com.designpatterns.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xu rongchao
 * @date 2020/10/19 21:11
 */
public class ChainDemo {

    public static void main(String[] args) {

    }

    static class FilterChain {
        List<Filter> filters = new ArrayList<>();
        void addChain(Filter filter) {
            filters.add(filter);
        }

        void exe(List list) {
            for (Filter filter : filters) {
                filter.filter(list);
            }
        }
    }

    interface Filter {
        void filter(List list);
    }

    static class AFilter implements Filter {

        @Override
        public void filter(List list) {

        }
    }
    static class BFilter implements Filter {

        @Override
        public void filter(List list) {

        }
    }
}
