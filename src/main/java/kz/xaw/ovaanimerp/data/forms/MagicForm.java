package kz.xaw.ovaanimerp.data.forms;

import javax.validation.constraints.NotBlank;

public class MagicForm extends BaseForm {
    @NotBlank(message = "{error.field.empty}")
    private String spellName;
    @NotBlank(message = "{error.field.empty}")
    private String effect;
    @NotBlank(message = "{error.field.empty}")
    private String spellLevel;
    @NotBlank(message = "{error.field.empty}")
    private Integer baseEnduranceCost;

    public String getSpellName(){return spellName;}
    public void setSpellName(String spellName){this.spellName = spellName;}

    public String getEffect(){return effect;}
    public void  setEffect(String effect){this.effect = effect;}

    public String getSpellLevel(){return spellLevel;}
    public void setSpellLevel(String spellLevel){this.spellLevel = spellLevel;}

    public Integer getBaseEnduranceCost(){return baseEnduranceCost;}
    public void setBaseEnduranceCost(Integer baseEnduranceCost){this.baseEnduranceCost = baseEnduranceCost;}
}
