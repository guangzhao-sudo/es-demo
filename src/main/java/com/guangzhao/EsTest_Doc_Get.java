package com.guangzhao;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;

public class EsTest_Doc_Get {
    public static void main(String[] args ) throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient= new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))


        );
        //查询数据
       GetRequest request=new GetRequest();
       request.index("user").id("1001");



        GetResponse getResponse = esClient.get(request, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString());

        //关闭ES客户端
        esClient.close();

    }
}
