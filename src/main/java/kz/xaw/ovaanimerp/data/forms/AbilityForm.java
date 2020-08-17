package kz.xaw.ovaanimerp.data.forms;
import javax.validation.constraints.NotBlank;
import java.util.List;


public class AbilityForm extends BaseForm {

    @NotBlank(message = "{error.field.empty}")
    private String name;
    private Integer level;
    @NotBlank(message = "{error.field.empty}")
    private String description;
    private List<MagicForm> magicForm;

    public List<MagicForm> getMagicForm() {
        return magicForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMagicForm(List<MagicForm> magicForm) {
        this.magicForm = magicForm;
    }
}
