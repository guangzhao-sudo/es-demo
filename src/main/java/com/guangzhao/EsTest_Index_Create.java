package com.guangzhao;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

public class EsTest_Index_Create {
    public static void main(String[] args ) throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient= new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))


        );
        //创建索引
        CreateIndexRequest request=new CreateIndexRequest("liake");
        CreateIndexResponse createIndexResponse = esClient.indices().create(request, RequestOptions.DEFAULT);
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引操作："+acknowledged);

        //关闭ES客户端
        esClient.close();

    }
}
