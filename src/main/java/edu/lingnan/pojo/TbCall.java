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
public class TbCall {
    private String id_data_contact;

    private Integer id_data_dimension;

    private Integer id_contact;

    private Integer call_sum;

    private Integer call_duration_sum;
}
