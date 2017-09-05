package hello.serviceResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by leandromaro on 20/7/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegularExpresion {
    private Integer id;

    private String field;

    private String expresion;

    @Override
    public String toString() {
        return "RegularExpresion{" +
                "id=" + id +
                ", field='" + field + '\'' +
                ", expresion='" + expresion + '\'' +
                '}';
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
}
