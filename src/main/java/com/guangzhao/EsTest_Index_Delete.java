package com.guangzhao;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

public class EsTest_Index_Delete {
    public static void main(String[] args ) throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient= new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))


        );
        //创建索引
        DeleteIndexRequest request=new DeleteIndexRequest("user");
        AcknowledgedResponse response = esClient.indices().delete(request, RequestOptions.DEFAULT);


        System.out.println("索引操作：" + response.isAcknowledged());


        //关闭ES客户端
        esClient.close();

    }
}
