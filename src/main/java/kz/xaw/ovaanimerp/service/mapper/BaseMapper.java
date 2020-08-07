package kz.xaw.ovaanimerp.service.mapper;

import kz.xaw.ovaanimerp.data.BaseEntity;
import kz.xaw.ovaanimerp.data.forms.BaseForm;

public interface BaseMapper<E extends BaseEntity, F extends BaseForm> {
    E formToEntity(F form);
    F entityToForm(E entity);
}
