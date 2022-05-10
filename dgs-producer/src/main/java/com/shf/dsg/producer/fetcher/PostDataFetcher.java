package com.shf.dsg.producer.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import com.shf.common.entity.Post;
import com.shf.common.entity.Review;
import com.shf.dsg.producer.service.PostService;
import com.shf.dsg.producer.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * description :
 * 当前主要描述federation示例，更多参考：https://netflix.github.io/dgs/federation/#customizing-the-default-federation-resolver
 * 通过federation，无需对entity在schema中定义固定的查询field，直接通过{@link @DgsEntityFetcher}即可暴露获取数据的方法。
 * 此处仅需在schema中定义当前entity对应的type即可，具体定义参考:
 * <pre>
 * type Post @key(fields: "id") @extends{
 *     id:ID @external
 *     name:String
 *     reviews: [Review]
 * }
 *
 * type Review {
 *     starRating: Int
 * }
 * </pre>
 *
 * @author songhaifeng
 * @date 2022/5/9 13:34
 */
@DgsComponent
@Slf4j
public class PostDataFetcher {

    @Autowired
    private PostService postService;
    @Autowired
    private ReviewService reviewService;

    /**
     * {@link DgsEntityFetcher}中的name属性对应了如下请求参数中的__typename字段，
     * 请求中具体对应的entity类型... on Post对应的是schema文件中的type配置项，如上类描述中的示例。
     * 可返回字段同样来源于当前指定type定义的字段清单。
     *
     * <pre>
     *     {
     *   _entities(representations: {id: 2, __typename: "PostAlias"}) {
     *     ... on Post {
     *       __typename
     *       id
     *       name
     *       reviews {
     *         starRating
     *       }
     *     }
     *   }
     * }
     * </pre>
     *
     * @param values 接收如上请求示例中representations: {id: 2, __typename: "PostAlias"}部分的map数据结构
     * @return {@link Post}
     */
    @DgsEntityFetcher(name = "PostAlias")
    public Post loadPostById(Map<String, Object> values) {
        log.info("{}", values);
        return postService.loadPostById(Integer.valueOf(values.get("id").toString()));
    }

    /**
     * 当获取Post实体中的reviews字段时，则会自动执行如下代码，获取对应数据集.
     * - parentType： 对应schema中type Post定义
     * - field： 对应schema中type Post定义下的指定字段reviews
     *
     * @param dataFetchingEnvironment dataFetchingEnvironment
     * @return list of {@link Review}
     */
    @DgsData(parentType = "Post", field = "reviews")
    public List<Review> reviewsFetcher(DgsDataFetchingEnvironment dataFetchingEnvironment) {
        Post post = dataFetchingEnvironment.getSource();
        return reviewService.loadById(post.getId());
    }

    /**
     * 通过{@link DgsEntityFetcher}批量获取数据集
     * <pre>
     *     {
     *   _entities(representations: {id: [1,2], __typename: "PostList"}) {
     *     ... on Post {
     *       __typename
     *       id
     *       name
     *       reviews {
     *         starRating
     *       }
     *     }
     *   }
     * }
     * </pre>
     *
     * @param values 接收如上请求示例中representations: {id: [1,2], __typename: "PostAlias"}部分的map数据结构。
     * @return list of {@link Post}
     */
    @DgsEntityFetcher(name = "PostList")
    public List<Post> list(Map<String, Object> values) {
        log.info("{}", values);
        return postService.list((List<BigInteger>) values.get("id"));
    }

}
