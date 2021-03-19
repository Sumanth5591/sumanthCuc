package com.qa.util;

import java.util.List;
import java.util.ListIterator;

public class ElementUtil {


    public static List<String> replaceLower(List<String> strings)
    {
        ListIterator<String> iterator = strings.listIterator();
        while (iterator.hasNext())
        {
            iterator.set(iterator.next().toLowerCase());
        }
        return strings;
    }

}
