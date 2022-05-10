package com.shf.dsg.producer.service;

import com.shf.common.entity.Director;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description :
 * 模拟从数据库根据movieId获取{@link Director}数据，此处提供必须提供批量获取能力
 *
 * @author songhaifeng
 * @date 2022/5/8 17:45
 */
@Service
@Slf4j
public class DirectorService {

    private Map<Integer, Director> movieRefDirector = new HashMap<Integer, Director>() {{
        put(3, new Director("d1", "abc"));
        put(2, new Director("d2", "efg"));
    }};

    public List<Director> loadDirectors(List<Integer> movieIds) {
        log.info("movieIds : {}", movieIds);
        return movieIds.stream().map(movieId -> movieRefDirector.get(movieId)).collect(Collectors.toList());
    }

    public Director loadDirector(Integer movieId) {
        return movieRefDirector.get(movieId);
    }

    public Map<Integer, Director> loadDirectors() {
        return movieRefDirector;
    }
}
