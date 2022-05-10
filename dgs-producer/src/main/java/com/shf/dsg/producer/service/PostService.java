package com.shf.dsg.producer.service;

import com.shf.common.entity.Post;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/9 13:24
 */
@Service
public class PostService {

    private Map<Integer, Post> posts = new HashMap<Integer, Post>() {{
        put(1, new Post(1, "foo"));
        put(2, new Post(2, "bar"));
        put(3, new Post(3, "zoo"));
    }};

    public Post loadPostById(Integer id) {
        return posts.get(id);
    }

    public List<Post> list(List<BigInteger> ids) {
        return ids.stream().map(id -> posts.get(id.intValue())).collect(Collectors.toList());
    }
}
