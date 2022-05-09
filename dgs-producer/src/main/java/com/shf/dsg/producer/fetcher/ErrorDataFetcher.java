package com.shf.dsg.producer.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsEnableDataFetcherInstrumentation;
import com.shf.dsg.producer.error.handler.CustomException;
import graphql.schema.DataFetchingEnvironment;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/9 1:06
 */
@DgsComponent
public class ErrorDataFetcher {

    /**
     * 如下同时获取两个数据，此时error返回值将在errors部分，并且在data部分为null。但hello仍然正常返回有效值在data结构体中
     * <pre>{
     *   error
     *   hello
     * }</pre>
     *
     * @param dfe DataFetchingEnvironment
     * @return String
     */
    @DgsData(parentType = "Query", field = "error")
    @DgsEnableDataFetcherInstrumentation(false)
    public String error(DataFetchingEnvironment dfe) {
        throw new CustomException();
    }

}
