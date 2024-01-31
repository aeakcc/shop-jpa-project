package com.yerlen.sort;

import com.yerlen.entity.ParentEntity;
import java.util.List;

public class AscendingSortStrategy <T extends ParentEntity> implements SortStrategy<T> {
    @Override
    public List<T> sort(List<T> items) {
        return items.stream().sorted().toList();
    }
    // lol che
}