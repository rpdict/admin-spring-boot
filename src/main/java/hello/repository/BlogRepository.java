package hello.repository;

import hello.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhaoruipeng
 * @ClassName BlogRepository
 * @Package hello
 * @Description TODO(干啥了)
 * @date 2018/3/23 14:53
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
