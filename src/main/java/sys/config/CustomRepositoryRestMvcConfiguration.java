package sys.config;

import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import sys.entity.Blog;
import sys.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * @author zhaoruipeng
 * @ClassName CustomRepositoryRestMvcConfiguration
 * @Package hello.config
 * @date 2018/3/27 15:05
 */

@Configuration
public class CustomRepositoryRestMvcConfiguration extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setRepositoryDetectionStrategy(RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED);
        config.exposeIdsFor(
                Blog.class
        );
    }
}
