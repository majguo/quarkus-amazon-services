package io.quarkus.amazon.iam.runtime;

import io.quarkus.amazon.common.runtime.AmazonClientRecorder;
import io.quarkus.amazon.common.runtime.AsyncHttpClientConfig;
import io.quarkus.amazon.common.runtime.AwsConfig;
import io.quarkus.amazon.common.runtime.SdkConfig;
import io.quarkus.amazon.common.runtime.SyncHttpClientConfig;
import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.annotations.Recorder;
import software.amazon.awssdk.awscore.client.builder.AwsAsyncClientBuilder;
import software.amazon.awssdk.awscore.client.builder.AwsSyncClientBuilder;
import software.amazon.awssdk.services.iam.IamAsyncClient;
import software.amazon.awssdk.services.iam.IamClient;

@Recorder
public class IamRecorder extends AmazonClientRecorder {

    final IamConfig config;

    public IamRecorder(IamConfig config) {
        this.config = config;
    }

    @Override
    public RuntimeValue<AwsConfig> getAwsConfig() {
        return new RuntimeValue<>(config.aws);
    }

    @Override
    public RuntimeValue<SdkConfig> getSdkConfig() {
        return new RuntimeValue<>(config.sdk);
    }

    @Override
    public AsyncHttpClientConfig getAsyncClientConfig() {
        return config.asyncClient;
    }

    @Override
    public SyncHttpClientConfig getSyncClientConfig() {
        return config.syncClient;
    }

    @Override
    public AwsSyncClientBuilder<?, ?> geSyncClientBuilder() {
        return IamClient.builder();
    }

    @Override
    public AwsAsyncClientBuilder<?, ?> getAsyncClientBuilder() {
        return IamAsyncClient.builder();
    }
}
