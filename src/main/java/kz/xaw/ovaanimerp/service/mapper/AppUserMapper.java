package kz.xaw.ovaanimerp.service.mapper;

import kz.xaw.ovaanimerp.data.forms.AppUserForm;
import kz.xaw.ovaanimerp.security.AppUser;
import kz.xaw.ovaanimerp.service.AppUserService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = AppUserService.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AppUserMapper extends BaseMapper<AppUser, AppUserForm> {

}
