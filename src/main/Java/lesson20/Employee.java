package lesson20;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Employee {

    private int personnelNumber;
    private String login;
    private String fio;
    private Department department;
    private Position position;

}
