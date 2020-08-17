package kz.xaw.ovaanimerp.data.forms;

import kz.xaw.ovaanimerp.data.enums.AttributeType;

public class CharAttributeModifierForm extends BaseForm {

    private Integer level;
    private AttributeType type;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public AttributeType getType() {
        return type;
    }

    public void setType(AttributeType type) {
        this.type = type;
    }
}
