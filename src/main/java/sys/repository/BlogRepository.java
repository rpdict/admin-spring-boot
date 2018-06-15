package sys.repository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sys.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhaoruipeng
 * @ClassName BlogRepository
 * @Package hello
 * @Description TODO(干啥了)
 * @date 2018/3/23 14:53
 */

@CrossOrigin
@RestResource
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
