package kz.xaw.ovaanimerp.data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "attacks")
public class Attack extends BaseEntity {

    private String name;

    private String perksAndFlows;

    private String description;

    //Dice count
    private Integer roll;

    //Damage multiplier
    private Integer dx;

    //Lose of endurance for specific attack
    private Integer end;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerksAndFlows() {
        return perksAndFlows;
    }

    public void setPerksAndFlows(String perksAndFlows) {
        this.perksAndFlows = perksAndFlows;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public Integer getDx() {
        return dx;
    }

    public void setDx(Integer dx) {
        this.dx = dx;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
