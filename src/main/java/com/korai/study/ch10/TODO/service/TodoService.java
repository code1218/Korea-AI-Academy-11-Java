package com.korai.study.ch10.TODO.service;

import com.korai.study.ch10.TODO.entity.Todo;
import com.korai.study.ch10.TODO.repository.TodoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getTodoList() {
        return todoRepository.getTodos();
    }
}
