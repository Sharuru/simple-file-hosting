package self.srr.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Class read customized config
 *
 * Created by Sharuru on 2017/03/30.
 */
@Component
@ConfigurationProperties(prefix="sfh")
public class SfhConfiguration {

    private String storagePath;


    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }
}
