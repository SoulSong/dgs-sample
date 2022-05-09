package com.shf.dsg.producer.service;

import com.shf.dsg.producer.entity.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/9 13:25
 */
@Service
public class ReviewService {

    private final Map<Integer, List<Review>> reviews = new HashMap<Integer, List<Review>>() {{
        List<Review> review1 = new ArrayList<>();
        review1.add(new Review(1));
        review1.add(new Review(4));
        review1.add(new Review(5));
        put(1, review1);

        List<Review> review2 = new ArrayList<>();
        review2.add(new Review(3));
        review2.add(new Review(5));
        put(2, review2);
    }};

    public List<Review> loadById(Integer id) {
        return reviews.get(id);
    }
}
