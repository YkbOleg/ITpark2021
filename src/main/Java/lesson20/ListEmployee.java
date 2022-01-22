package lesson20;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement
public class ListEmployee {

    private List<Employee> employees;
}
