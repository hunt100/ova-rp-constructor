package kz.xaw.ovaanimerp.data;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "abilities")
public class Ability extends BaseEntity {

    @Column
    @NotBlank(message = "Не может быть пустым")
    private String name;

    @Range(min = 0, max = 5, message = "Сасай кудасай выше уровень нельзя")
    @Column
    private Integer level;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    @OneToMany
    private List<Magic> magic;

    @OneToMany
    private List<CharsAttributeModifier> modifierList;

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

    public List<CharsAttributeModifier> getModifierList() {
        return modifierList;
    }

    public void setModifierList(List<CharsAttributeModifier> modifierList) {
        this.modifierList = modifierList;
    }
}
