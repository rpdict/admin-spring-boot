package hello.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * @author zhaoruipeng
 * @ClassName Blog
 * @Package hello
 * @Description TODO(干啥了)
 * @date 2018/3/23 14:40
 */

@Data
@Entity
public class Blog {

    private @Id @GeneratedValue Long id;
    private Integer uid;
    private String title;
    private String content;

//    private @Version @JsonIgnore Long version;

//    private @ManyToOne User user;

}
