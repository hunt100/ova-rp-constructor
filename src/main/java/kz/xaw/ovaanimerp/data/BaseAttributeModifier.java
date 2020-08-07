package kz.xaw.ovaanimerp.data;

import kz.xaw.ovaanimerp.data.enums.AttributeType;
import kz.xaw.ovaanimerp.data.enums.CharacteristicType;

import javax.persistence.*;

@Entity
@DiscriminatorValue(AttributeType.BASE_ATTRIBUTE_VALUE)
public class BaseAttributeModifier extends CharsAttributeModifier {

    @Column
    private Integer modifier;

    @Column
    @Enumerated(EnumType.STRING)
    private CharacteristicType characteristicType;


    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public CharacteristicType getCharacteristicType() {
        return characteristicType;
    }

    public void setCharacteristicType(CharacteristicType characteristicType) {
        this.characteristicType = characteristicType;
    }
}
