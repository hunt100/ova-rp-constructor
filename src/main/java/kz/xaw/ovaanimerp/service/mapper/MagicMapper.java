package kz.xaw.ovaanimerp.service.mapper;

import kz.xaw.ovaanimerp.data.Magic;
import kz.xaw.ovaanimerp.data.forms.MagicForm;
import kz.xaw.ovaanimerp.service.MagicService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = MagicService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MagicMapper extends BaseMapper<Magic, MagicForm> {

}
