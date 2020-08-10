package kz.xaw.ovaanimerp.service.mapper;

import kz.xaw.ovaanimerp.data.Weakness;
import kz.xaw.ovaanimerp.data.forms.WeaknessForm;
import kz.xaw.ovaanimerp.service.WeaknessService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
    uses = WeaknessService.class,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)

public interface WeaknessMapper extends  BaseMapper<Weakness, WeaknessForm> {
}
