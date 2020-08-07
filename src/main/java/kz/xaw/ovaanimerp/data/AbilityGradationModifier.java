package kz.xaw.ovaanimerp.data;

import kz.xaw.ovaanimerp.data.enums.AttributeType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(AttributeType.ABILITY_GRADATION_VALUE)
public class AbilityGradationModifier extends CharsAttributeModifier{

    @Column
    private String textDescription;

    @Column
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
