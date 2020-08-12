package kz.xaw.ovaanimerp.data;

import javax.persistence.Entity;

//flaws
@Entity(name = "perks")
public class Perk extends BaseEntity {

    private String name;
    private String description;
    private Integer level;
    private Integer endurancePerLevel;
    private Integer rollPerLevel;
    private Integer dxPerLevel;

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

    public Integer getEndurancePerLevel() {
        return endurancePerLevel;
    }

    public void setEndurancePerLevel(Integer endurancePerLevel) {
        this.endurancePerLevel = endurancePerLevel;
    }

    public Integer getRollPerLevel() {
        return rollPerLevel;
    }

    public void setRollPerLevel(Integer rollPerLevel) {
        this.rollPerLevel = rollPerLevel;
    }

    public Integer getDxPerLevel() {
        return dxPerLevel;
    }

    public void setDxPerLevel(Integer dxPerLevel) {
        this.dxPerLevel = dxPerLevel;
    }

    public Integer getFullCost(Integer level, Integer attrPerLevel) {
        return level * attrPerLevel;
    }
}
