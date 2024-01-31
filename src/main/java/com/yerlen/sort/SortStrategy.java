package com.yerlen.sort;

import com.yerlen.entity.Category;
import com.yerlen.entity.ParentEntity;

import java.util.List;

public interface SortStrategy<T extends ParentEntity> {
    List<T> sort(List<T> items);
}