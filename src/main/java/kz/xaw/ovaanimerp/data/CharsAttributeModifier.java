package kz.xaw.ovaanimerp.data;

import kz.xaw.ovaanimerp.data.enums.AttributeType;

import javax.persistence.*;

@Entity(name = "chars_attributes_modifiers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class CharsAttributeModifier extends BaseEntity {

    @Column
    private Integer level;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, updatable = false, insertable = false)
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
