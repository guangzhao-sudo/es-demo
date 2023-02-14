package com.guangzhao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

public class EsTest_Doc_Insert {
    public static void main(String[] args ) throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient= new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))


        );
        IndexRequest request=new IndexRequest();
        request.index("user").id("1001");
        User user=new User();
        user.setName("掌握");
        user.setAge(30);
        user.setSex("男");

        //向Es插入数据必须将数据转换为JSON格式
        ObjectMapper mapper=new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        request.source(userJson, XContentType.JSON);
        IndexResponse respon = esClient.index(request, RequestOptions.DEFAULT);
        respon.getResult();
        respon.getId();
        System.out.println(   respon.getResult());
        System.out.println(respon.getId() );
        //关闭ES客户端
        esClient.close();

    }
}
