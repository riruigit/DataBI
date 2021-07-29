package edu.lingnan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 18364
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private String year;
    private String month;
    private String day;
    private String id;
    private Integer callNum;
}
