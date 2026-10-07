package com.korai.study.ch10.TODO.repository;

import com.korai.study.ch10.TODO.entity.Todo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    @Getter
    private List<Todo> todos;

    public TodoRepository() {
        todos = new ArrayList<>();
    }
}
