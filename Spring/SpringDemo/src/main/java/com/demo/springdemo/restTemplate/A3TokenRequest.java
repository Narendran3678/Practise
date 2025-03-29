package com.demo.springdemo.restTemplate;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class A3TokenRequest {
    @SerializedName("appId")
    private Long senderAppid;

    @SerializedName("appPassword")
    private String appPassword;

    @SerializedName("context")
    private String context;

    @SerializedName("otherApp")
    private Long receiverAppid;

    @SerializedName("contextVersion")
    private Long contextVersion;
}