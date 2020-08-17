package kz.xaw.ovaanimerp.service.mapper;

import kz.xaw.ovaanimerp.data.forms.AbilityGradationModifierForm;
import kz.xaw.ovaanimerp.data.AbilityGradationModifier;
import kz.xaw.ovaanimerp.service.CharAttributeService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = CharAttributeService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AbilityGradationModifierMapper extends BaseMapper<AbilityGradationModifier, AbilityGradationModifierForm> {

}