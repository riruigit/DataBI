package edu.lingnan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author 18364
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component

public class Index {
    ArrayList callSum;
    ArrayList callTimeSum;

}
