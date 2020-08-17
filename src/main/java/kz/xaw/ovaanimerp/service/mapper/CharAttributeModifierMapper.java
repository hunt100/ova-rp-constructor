package kz.xaw.ovaanimerp.service.mapper;

import kz.xaw.ovaanimerp.data.CharsAttributeModifier;
import kz.xaw.ovaanimerp.data.forms.CharAttributeModifierForm;
import kz.xaw.ovaanimerp.service.CharAttributeService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = CharAttributeService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)

public interface CharAttributeModifierMapper extends BaseMapper<CharsAttributeModifier,CharAttributeModifierForm> {

}
