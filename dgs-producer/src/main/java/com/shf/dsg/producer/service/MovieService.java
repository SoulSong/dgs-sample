package com.shf.dsg.producer.service;

import com.shf.common.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/8 19:35
 */
@Service
public class MovieService {

    private List<Movie> movies = new ArrayList<Movie>() {{
        add(new Movie(1, "钢铁侠"));
        add(new Movie(2, "功夫熊猫"));
        add(new Movie(3, "水门桥"));
    }};

    public List<Movie> listAll() {
        return movies;
    }
}
