package com.guangzhao;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class EsTest_Client_Insert_Batch {
    public static void main(String[] args ) throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient= new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))


        );
        //批量插入数据
        BulkRequest request=new BulkRequest();
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","李四"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","王五"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","张三"));
        BulkResponse bulk = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(bulk.getIngestTook());
        System.out.println(bulk.getIngestTook());

        //关闭ES客户端
        esClient.close();

    }
}
