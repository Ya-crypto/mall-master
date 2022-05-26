package com.macro.mall.search;

import org.apache.http.HttpHost;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Collections;

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
    public void test() throws IOException {
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
        UpdateRequest request = new UpdateRequest();
        request.index("user").id("1001");
        request.doc(XContentType.JSON,"age",30);
        UpdateResponse response = esClinent.update(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
        //关闭客户端
        esClinent.close();
    }

}
