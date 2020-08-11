package kz.xaw.ovaanimerp.service.mapper;

import kz.xaw.ovaanimerp.data.Ability;
import kz.xaw.ovaanimerp.data.forms.AbilityForm;
import kz.xaw.ovaanimerp.service.AbilityService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = AbilityService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AbilityMapper extends BaseMapper<Ability, AbilityForm> {

}