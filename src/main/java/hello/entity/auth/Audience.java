package hello.entity.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zhaoruipeng
 * @ClassName Audience
 * @Package hello.entity.auth
 * @Description 配置信息的实体类，以便获取jwt的配置
 * @date 2018/5/28 10:32
 */
@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {

    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresSecond;

}