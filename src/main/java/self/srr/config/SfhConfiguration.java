package self.srr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Class read customized config
 * <p>
 * Created by Sharuru on 2017/03/30.
 */
@Component
@ConfigurationProperties(prefix = "sfh")
public class SfhConfiguration {

    private String storagePath;

    private String exposedLink;

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public String getExposedLink() {
        return exposedLink;
    }

    public void setExposedLink(String exposedLink) {
        this.exposedLink = exposedLink;
    }
}
