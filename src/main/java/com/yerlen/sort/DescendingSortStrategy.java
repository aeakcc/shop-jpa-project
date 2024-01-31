package com.yerlen.sort;

import com.yerlen.entity.Category;
import com.yerlen.entity.ParentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DescendingSortStrategy <T extends ParentEntity> implements SortStrategy<T> {
    @Override
    public List<T> sort(List<T> items) {
        return items.stream().sorted().collect(Collectors.toList());
    }
}
