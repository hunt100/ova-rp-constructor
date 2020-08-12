package kz.xaw.ovaanimerp.data.forms;
import javax.validation.constraints.NotBlank;
import java.util.List;


public class AbilityGradationModifierForm extends BaseForm{
    private String textDescription;
    private Integer dn;

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public Integer getDn() {
        return dn;
    }

    public void setDn(Integer dn) {
        this.dn = dn;
    }
}
