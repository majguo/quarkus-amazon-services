package io.quarkus.amazon.kms.runtime;

import io.quarkus.amazon.common.runtime.AsyncHttpClientBuildTimeConfig;
import io.quarkus.amazon.common.runtime.DevServicesBuildTimeConfig;
import io.quarkus.amazon.common.runtime.SdkBuildTimeConfig;
import io.quarkus.amazon.common.runtime.SyncHttpClientBuildTimeConfig;
import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

/**
 * Amazon KMS build time configuration
 */
@ConfigRoot(name = "kms", phase = ConfigPhase.BUILD_AND_RUN_TIME_FIXED)
public class KmsBuildTimeConfig {

    /**
     * SDK client configurations for AWS KMS client
     */
    @ConfigItem(name = ConfigItem.PARENT)
    public SdkBuildTimeConfig sdk;

    /**
     * Sync HTTP transport configuration for Amazon KMS client
     */
    @ConfigItem
    public SyncHttpClientBuildTimeConfig syncClient;

    /**
     * Async HTTP transport configuration for Amazon KMS client
     */
    @ConfigItem
    public AsyncHttpClientBuildTimeConfig asyncClient;

    /**
     * Config for dev services
     */
    @ConfigItem
    public DevServicesBuildTimeConfig devservices;
}
