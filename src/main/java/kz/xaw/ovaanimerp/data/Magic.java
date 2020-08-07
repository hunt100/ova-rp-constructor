package kz.xaw.ovaanimerp.data;

import javax.persistence.*;

@Entity(name = "magic")
public class Magic extends BaseEntity{

    @Column
    private String spellName;

    @Column
    private String effect;

    @Column
    private Integer spellLevel;

    @Column
    private Integer baseEnduranceCost;


    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Integer getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(Integer spellLevel) {
        this.spellLevel = spellLevel;
    }

    public Integer getBaseEnduranceCost() {
        return baseEnduranceCost;
    }

    public void setBaseEnduranceCost(Integer baseEnduranceCost) {
        this.baseEnduranceCost = baseEnduranceCost;
    }
}
