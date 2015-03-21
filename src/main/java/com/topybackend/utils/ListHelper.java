package com.topybackend.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashanth.a on 20/03/15.
 */
public class ListHelper{
    public static <T> List<T> merge(List<T>... args) {
        final List<T> result = new ArrayList<T>();

        for (List<T> list : args) {
            result.addAll(list);
        }

        return result;
    }
}
