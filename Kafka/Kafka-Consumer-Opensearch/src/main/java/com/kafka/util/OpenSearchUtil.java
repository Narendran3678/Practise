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
import java.net.URI;
public class OpenSearchUtil {
    public static final Logger logger = LoggerFactory.getLogger(OpenSearchUtil.class.getSimpleName());
    private static RestHighLevelClient restHighLevelClient;
    private static RestHighLevelClient createOpenSearchClient() {
        System.setProperty("javax.net.ssl.trustStore", KafkaConstants.TRUSTSTORE_PATH);
        System.setProperty("javax.net.ssl.trustStorePassword", KafkaConstants.TRUSTSTORE_PASSWORD);
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider() ;
        URI uriConnection = URI.create(KafkaConstants.OPENSEARCH_URL);

        // extract login information if it exists
        String userInfo = uriConnection.getUserInfo();
        logger.info("Url..."+uriConnection.getHost()+", Port..."+uriConnection.getPort()+", Scheme..."+uriConnection.getScheme()+", userInfo..."+userInfo);
        credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials("admin","#1KafElasSrh"));
        if(userInfo!=null) {
            // REST client with security
            String[] auth = userInfo.split(":");
            logger.info("Username..."+auth[0]+", Password..."+auth[1]);
            credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(auth[0],auth[1]));
        }
        restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(uriConnection.getHost(), uriConnection.getPort(), uriConnection.getScheme())
                ).setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
                        .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy()))
        );
        return restHighLevelClient;
    }
    public static RestHighLevelClient getRestHighLevelClient() throws Exception {
        if(restHighLevelClient == null) {
            restHighLevelClient = createOpenSearchClient();
        }
        if(restHighLevelClient==null) {
            throw new Exception("Client Generation is Null");
        }
        return restHighLevelClient;
    }
    public static boolean createIndexes(String osIndex) throws Exception {
        osIndex = osIndex.toLowerCase();
        restHighLevelClient = getRestHighLevelClient();
        if(!checkIndexExist(osIndex)) {
            restHighLevelClient.indices().create(new CreateIndexRequest(osIndex),RequestOptions.DEFAULT);
            logger.error("Index ["+osIndex+"] Created");
        }
        else {
            logger.error("Index Already Exist");
        }
        return true;
    }
    public static boolean checkIndexExist(String osIndex) throws Exception {
        restHighLevelClient = getRestHighLevelClient();
        return restHighLevelClient.indices().exists(new GetIndexRequest(osIndex), RequestOptions.DEFAULT);
    }

}
