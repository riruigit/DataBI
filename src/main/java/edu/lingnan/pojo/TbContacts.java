package edu.lingnan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 18364
 * 参数 自增id 手机号码 姓名
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component

public class TbContacts {
    private Integer id;

    private String telephone;

    private String name;
}
