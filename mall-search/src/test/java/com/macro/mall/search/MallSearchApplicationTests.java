package com.macro.mall.search;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallSearchApplicationTests {
//    @Autowired
//    private EsProductDao productDao;
//    @Autowired
//    private ElasticsearchRestTemplate elasticsearchTemplate;
//    @Test
//    public void contextLoads() {
//    }
//    @Test
//    public void testGetAllEsProductList(){
//        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
//        System.out.print(esProductList);
//    }
//    @Test
//    public void testEsProductMapping(){
//        IndexOperations indexOperations = elasticsearchTemplate.indexOps(EsProduct.class);
//        indexOperations.putMapping(indexOperations.createMapping(EsProduct.class));
//        Map mapping = indexOperations.getMapping();
//        System.out.println(mapping);
//    }

    @Test
    public void testBaseSE() throws IOException {
        //创建es客户端
        RestHighLevelClient esClinent =  new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http")));

        //创建索引
//        CreateIndexRequest request = new CreateIndexRequest("user");
//        CreateIndexResponse createIndexResponse = esClinent.indices().create(request, RequestOptions.DEFAULT);
//        boolean acknowledged = createIndexResponse.isAcknowledged();
//        System.out.println("创建索引"+acknowledged);

        //查询索引
//        GetIndexRequest request = new GetIndexRequest("user");
//        GetIndexResponse getIndexResponse = esClinent.indices().get(request, RequestOptions.DEFAULT);
//        System.out.println(getIndexResponse.getAliases());
//        System.out.println(getIndexResponse.getMappings());
//        System.out.println(getIndexResponse.getSettings());

        //删除索引
//        DeleteIndexRequest request = new DeleteIndexRequest("user");
//        AcknowledgedResponse acknowledged = esClinent.indices().delete(request, RequestOptions.DEFAULT);
//        System.out.println("删除索引"+acknowledged);

        //插入数据
//        IndexRequest request = new IndexRequest();
//        request.index("user").id("1001");
//        EsUser user = new EsUser("zhangsan","12345",25);
//        ObjectMapper mapper = new ObjectMapper();
//        String userStr = mapper.writeValueAsString(user);
//        request.source(userStr, XContentType.JSON);
//        IndexResponse response = esClinent.index(request, RequestOptions.DEFAULT);
//        System.out.println(response.getResult());

        //修改数据
//        UpdateRequest request = new UpdateRequest();
//        request.index("user").id("1001");
//        request.doc(XContentType.JSON,"age",30);
//        UpdateResponse response = esClinent.update(request, RequestOptions.DEFAULT);
//        System.out.println(response.getResult());

        //查询数据
//        GetRequest request = new GetRequest();
//        request.index("user").id("1001");
//        GetResponse response = esClinent.get(request, RequestOptions.DEFAULT);
//        System.out.println(response.getSourceAsString());

        //删除数据
//        DeleteRequest request = new DeleteRequest();
//        request.index("user").id("1001");
//        DeleteResponse response = esClinent.delete(request, RequestOptions.DEFAULT);
//        System.out.println(response.getResult());

        //批量插入数据
//        BulkRequest request = new BulkRequest();
//        for(int i=0;i<100000;i++){
//            EsUser user = new EsUser("zhangsan" + i, "admin" + i, i, "测试" + i);
//            String json = new ObjectMapper().writeValueAsString(user);
//            request.add(new IndexRequest().index("user").id(UUID.randomUUID().toString()).source(json,XContentType.JSON));
//        }
//        request.add(new IndexRequest().index("user").id("4001").source(XContentType.JSON,"name","lisi","age",25,"sex","男"));
//        request.add(new IndexRequest().index("user").id("4002").source(XContentType.JSON,"name","wangwu","age",15,"sex","男"));
//        request.add(new IndexRequest().index("user").id("4003").source(XContentType.JSON,"name","zhaoliu","age",35,"sex","女"));
//        request.add(new IndexRequest().index("user").id("4004").source(XContentType.JSON,"name","zhaoliu1","age",35,"sex","女"));
//        request.add(new IndexRequest().index("user").id("4005").source(XContentType.JSON,"name","zhaoliu2","age",35,"sex","男"));
//        request.add(new IndexRequest().index("user").id("4006").source(XContentType.JSON,"name","zhaoliu3","age",35,"sex","女"));
//        BulkResponse response = esClinent.bulk(request, RequestOptions.DEFAULT);
//        System.out.println(response.getTook());//执行时间
        //System.out.println(response.getItems());

        //批量删除
//        BulkRequest request = new BulkRequest();
//        request.add(new DeleteRequest().index("user").id("2001"));
//        request.add(new DeleteRequest().index("user").id("2002"));
//        request.add(new DeleteRequest().index("user").id("2003"));
//        BulkResponse response = esClinent.bulk(request, RequestOptions.DEFAULT);
//        System.out.println(response.getTook());//执行时间
//        System.out.println(response.getItems());

        //全量查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//        SearchResponse response = esClinent.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        for(SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
        //条件查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("name","lisi")));
//        SearchResponse response = esClinent.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        for(SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
        //分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().query(QueryBuilders.termQuery("sex","女"));
//        sourceBuilder.sort("age", SortOrder.ASC);
//        sourceBuilder.from(0);
//        sourceBuilder.size(2);
//        String[] excludes = {"age"};
//        String[] includes= {};
//        sourceBuilder.fetchSource(includes,excludes);
//        request.source(sourceBuilder);
//
//        SearchResponse response = esClinent.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        for(SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

       //组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.must(QueryBuilders.matchQuery("sex","男"));
//        //boolQueryBuilder.must(QueryBuilders.matchQuery("age",15));
//        //boolQueryBuilder.should(QueryBuilders.matchQuery("age",35));或者可以是35
//        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
//        rangeQueryBuilder.gte(15);
//        rangeQueryBuilder.lte(35);
//        sourceBuilder.query(boolQueryBuilder);
//        sourceBuilder.query(rangeQueryBuilder);
//        request.source(sourceBuilder);
//        SearchResponse response = esClinent.search(request, RequestOptions.DEFAULT);
//        System.out.println(response.getTook());
//        SearchHits hits = response.getHits();
//        for(SearchHit hit:hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //范围查询
        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
        rangeQueryBuilder.gte(15);
        //rangeQueryBuilder.lte(35);
        sourceBuilder.query(rangeQueryBuilder);
        request.source(sourceBuilder);
        SearchResponse response = esClinent.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        SearchHits hits = response.getHits();
        for(SearchHit hit:hits){
            System.out.println(hit.getSourceAsString());
        }

        //模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        //FuzzyQueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", "zhaoliu").fuzziness(Fuzziness.ONE);
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font style='color:red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//        sourceBuilder.highlighter(highlightBuilder);
//        sourceBuilder.query(QueryBuilders.matchQuery("name", "zhaoliu"));
//        request.source(sourceBuilder);
//        SearchResponse response = esClinent.search(request, RequestOptions.DEFAULT);
//        System.out.println(response.getTook());
//        System.out.println(response.toString());
//        SearchHits hits = response.getHits();
//        for(SearchHit hit:hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //关闭客户端
        esClinent.close();
    }

}
