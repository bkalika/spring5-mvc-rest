package guru.springfamework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by bogdan.kalika@gmail.com
 * Date: 5/8/2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerListDTO {
    private List<CustomerDTO> customers;
}
