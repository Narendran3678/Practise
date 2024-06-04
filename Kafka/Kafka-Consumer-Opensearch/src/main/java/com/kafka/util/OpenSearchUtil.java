package com.kafka.util;

import com.kafka.constant.KafkaConstants;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.client.indices.CreateIndexRequest;
import org.opensearch.client.indices.GetIndexRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.URI;
public class OpenSearchUtil {
    public static final Logger logger = LoggerFactory.getLogger(OpenSearchUtil.class.getSimpleName());
    private static RestHighLevelClient restHighLevelClient;
    public static RestHighLevelClient createOpenSearchClient() {
        URI uriConnection = URI.create(KafkaConstants.OPENSEARCH_URL);
        logger.info("Url..."+uriConnection.getHost()+", Port..."+uriConnection.getPort());
        // extract login information if it exists
        String userInfo = uriConnection.getUserInfo();

        if(userInfo==null) {
            restHighLevelClient = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost(uriConnection.getHost(), uriConnection.getPort(), uriConnection.getScheme())
                    )
            );
        }
        else {
            // REST client with security
            String[] auth = userInfo.split(":");
            logger.info("Username..."+auth[0]+", Password..."+auth[1]);
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider() ;
            credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(auth[0],auth[1]));
            restHighLevelClient = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost(uriConnection.getHost(), uriConnection.getPort(), uriConnection.getScheme())
                    ).setHttpClientConfigCallback(httpClientBuilder -> {
                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
                                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
                    })
            );
        }
        return restHighLevelClient;
    }
    public static boolean createIndexes(String osIndex) {
        osIndex = osIndex.toLowerCase();
        if(restHighLevelClient == null) {
            restHighLevelClient = createOpenSearchClient();
        }
        try {
            if(!checkIndexExist(osIndex)) {
                restHighLevelClient.indices().create(new CreateIndexRequest(osIndex),RequestOptions.DEFAULT);
                logger.error("Index ["+osIndex+"] Created");
            }
            else {
                logger.error("Index Already Exist");
            }
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
    public static boolean checkIndexExist(String osIndex) throws IOException {
        if(restHighLevelClient == null) {
            restHighLevelClient = createOpenSearchClient();
        }
        return restHighLevelClient.indices().exists(new GetIndexRequest(osIndex), RequestOptions.DEFAULT);
    }
}
