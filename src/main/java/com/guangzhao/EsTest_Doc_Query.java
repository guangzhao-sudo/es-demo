package com.guangzhao;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

public class EsTest_Doc_Query {
    public static void main(String[] args ) throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient= new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))


        );
        //查询索引中全部的数据数据
//      SearchRequest request=new SearchRequest();
//        request.indices("user");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//
//
//        SearchResponse searchResponse = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//
//
//        System.out.println(searchResponse.getTook());
//      for (SearchHit hits1:hits){
//          System.out.println(hits1.getSourceAsString());
//      }
//      //条件查询 termQuery
//        SearchRequest request=new SearchRequest();
//        request.indices("user");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age","30")));
//
//
//        SearchResponse searchResponse = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//
//
//        System.out.println(searchResponse.getTook());
//        for (SearchHit hits1:hits){
//            System.out.println(hits1.getSourceAsString());
//        }
//        //分页查询 termQuery
//        SearchRequest request=new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder=new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //当前页面-1*每页显示数据条数
//        builder.from(2);
//        builder.size(2);
//        request.source(builder);
//
//
//        SearchResponse searchResponse = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//
//
//        System.out.println(searchResponse.getTook());
//        for (SearchHit hits1:hits){
//            System.out.println(hits1.getSourceAsString());
//        }
//        //查询排序
//        SearchRequest request=new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder=new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //当前页面-1*每页显示数据条数
//        builder.sort("age", SortOrder.ASC);
//        request.source(builder);
//
//
//        SearchResponse searchResponse = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//
//
//        System.out.println(searchResponse.getTook());
//        for (SearchHit hits1:hits){
//            System.out.println(hits1.getSourceAsString());
//        }
        //过滤查询
//        SearchRequest request=new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder=new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        String[] excludes={};
//        String[] includes={"name"};
//        builder.fetchSource(includes,excludes);
//
//
//        request.source(builder);
//
//
//        SearchResponse searchResponse = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//
//
//
//
//        System.out.println(searchResponse.getTook());
//        for (SearchHit hits1:hits){
//            System.out.println(hits1.getSourceAsString());
//            System.out.println(hits1.getId());
//        }
//        //组合查询
//        SearchRequest request=new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder=new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.must(QueryBuilders.matchQuery("age",30));
//        boolQueryBuilder.must(QueryBuilders.matchQuery("sex","男"));
//        builder.query(boolQueryBuilder);
//
//        request.source(builder);
//
//
//        SearchResponse searchResponse = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//
//
//
//
//        System.out.println(searchResponse.getTook());
//        for (SearchHit hits1:hits){
//            System.out.println(hits1.getSourceAsString());
//            System.out.println(hits1.getId());
//        }
//        //模糊查询
//        SearchRequest request=new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder=new SearchSourceBuilder();
//      builder.query(QueryBuilders.fuzzyQuery("name","张三").fuzziness(Fuzziness.ONE));
//
//        request.source(builder);
//
//
//        SearchResponse searchResponse = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//
//
//        System.out.println(hits.getTotalHits());
//
//
//        System.out.println(searchResponse.getTook());
//        for (SearchHit hits1:hits){
//            System.out.println(hits1.getSourceAsString());
//            System.out.println(hits1.getId());
//        }
        //聚合查询
        SearchRequest request=new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder=new SearchSourceBuilder();
        AggregationBuilder aggregationBuilder= AggregationBuilders.max("maxAge").field("age");
        builder.aggregation(aggregationBuilder);
        
        request.source(builder);


        SearchResponse searchResponse = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();


        System.out.println(hits.getTotalHits());


        System.out.println(searchResponse.getTook());
        for (SearchHit hits1:hits){
            System.out.println(hits1.getSourceAsString());
            System.out.println(hits1.getId());
        }
        //关闭ES客户端
        esClient.close();

    }
}
