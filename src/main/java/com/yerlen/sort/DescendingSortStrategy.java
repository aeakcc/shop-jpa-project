package com.yerlen.sort;

import java.util.Comparator;
import java.util.List;

public class DescendingSortStrategy <T extends Comparable<T>> implements SortStrategy<T> {
    @Override
    public List<T> sort(List<T> items) {
        return items.stream().sorted(Comparator.reverseOrder()).toList();
    }
}
