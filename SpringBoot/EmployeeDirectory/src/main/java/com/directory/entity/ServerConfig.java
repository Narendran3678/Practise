package com.directory.entity;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.util.*;
@Component
@PropertySource(value = "classpath:serverconfig.properties",ignoreResourceNotFound = false)
@ConfigurationProperties(prefix = "serverconf")
public class ServerConfig {
    private String hostName;
    private String port;
    private String gitUrl;
    private Map<String,String> credentials;
    private List<String> mappings;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public Map<String, String> getCredentials() {
        return credentials;
    }

    public void setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
    }

    public List<String> getMappings() {
        return mappings;
    }

    public void setMappings(List<String> mappings) {
        this.mappings = mappings;
    }

    @Override
    public String toString() {
        return "ServerConfig{" +
                "hostName='" + hostName + '\'' +
                ", port='" + port + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", credentials=" + credentials +
                ", mappings=" + mappings +
                '}';
    }
}
