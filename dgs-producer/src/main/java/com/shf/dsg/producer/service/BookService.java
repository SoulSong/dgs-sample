package com.shf.dsg.producer.service;

import com.shf.dsg.producer.entity.Actor;
import com.shf.dsg.producer.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/4 12:47
 */
@Service
public class BookService {
    private final Map<Integer, Book> books = new HashMap<Integer, Book>() {
        {
            put(1, new Book("Stranger Things", 2016, Arrays.asList(new Actor("foo1", 1), new Actor("foo2", 1))));
            put(2, new Book("Ozark", 2017, Arrays.asList(new Actor("bar2", 1), new Actor("bar2", 1))));
            put(3, new Book("The Crown", 2016, Arrays.asList(new Actor("foo1", 1), new Actor("bar2", 1))));
            put(4, new Book("Dead to Me", 2019, Collections.singletonList(new Actor("foo1", 1))));
            put(5, new Book("Orange is the New Black", 2013, Arrays.asList(new Actor("foo2", 1), new Actor("bar1", 1))));
        }
    };

    public List<Book> list(String titleFilter) {
        if (titleFilter == null) {
            return new ArrayList<>(books.values());
        }

        return books.values().stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }

    public Book get(Integer id) {
        return books.get(id);
    }

    public Map<Integer, Book> loadByIds(Set<Integer> ids) {
        return ids.stream().collect(Collectors.toMap(id -> id, books::get));
    }
}
