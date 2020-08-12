package kz.xaw.ovaanimerp.data.forms;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class WeaknessForm extends BaseForm {
    private String name;
    private String description;
    private Integer level;
    private CharAttributeModifierForm charAttributeModifierForm;

    public List<CharAttributeModifierForm> getCharAttributeForm() {
        List<CharAttributeModifierForm> charAttributeModifierForm = (List<CharAttributeModifierForm>) this.charAttributeModifierForm;
        return charAttributeModifierForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public CharAttributeModifierForm getCharAttributeModifierForm() {
        return charAttributeModifierForm;
    }

    public void setCharAttributeModifierForm(CharAttributeModifierForm charAttributeModifierForm) {
        this.charAttributeModifierForm = charAttributeModifierForm;
    }
}
