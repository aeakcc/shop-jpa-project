package com.yerlen.sort;

import java.util.List;
import java.util.stream.Collectors;

public class AscendingSortStrategy <T extends Comparable<T>> implements SortStrategy<T> {
    @Override
    public List<T> sort(List<T> items) {
        return items.stream().sorted().toList();
    }
}