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
public class TbDimensionDate {
    private Integer id;

    private Integer year;

    private Integer month;

    private Integer day;
}
