package com.guangzhao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class EsTest_Doc_update {
    public static void main(String[] args ) throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient= new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))


        );
        //修改数据
       UpdateRequest request=new UpdateRequest();
        request.index("user").id("1001");
        request.doc(XContentType.JSON,"sex","男","name","李四");


        UpdateResponse updateResponse = esClient.update(request, RequestOptions.DEFAULT);
        System.out.println(updateResponse.getResult());

        //关闭ES客户端
        esClient.close();

    }
}
