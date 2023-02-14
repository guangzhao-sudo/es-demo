package com.guangzhao;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

public class EsTest_Index_Search {
    public static void main(String[] args ) throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient= new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))


        );
        //创建索引
        GetIndexRequest request=new GetIndexRequest("user");
        GetIndexResponse indexResponse = esClient.indices().get(request, RequestOptions.DEFAULT);



        System.out.println("索引操作："+indexResponse.getAliases());
        System.out.println("索引操作："+indexResponse.getMappings());
        System.out.println("索引操作："+indexResponse.getDataStreams());
        System.out.println("索引操作："+indexResponse.getIndices());

        //关闭ES客户端
        esClient.close();

    }
}
