package com.edwincruz.stackoverflow.mapstructcontext.mapper;

import com.edwincruz.stackoverflow.mapstructcontext.IEnumDefinitionDao;
import com.edwincruz.stackoverflow.mapstructcontext.model.EnumDefinition;
import com.edwincruz.stackoverflow.mapstructcontext.model.EnumValue;
import com.edwincruz.stackoverflow.mapstructcontext.model.EnumValueBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class EnumValueMapperWithAutowiredBean {

    protected IEnumDefinitionDao enumDefinitionDao;

    @Autowired
    public final void setEnumDefinitionDao(IEnumDefinitionDao enumDefinitionDao) {
        this.enumDefinitionDao = enumDefinitionDao;
    }

    @Mapping(target = "enumDefinition", source = "enumDefinitionId", qualifiedByName = "getEnumDefinition")
    public abstract EnumValue toEntity(EnumValueBean enumValueBean);

    @Mapping(target = "enumDefinitionId", source = "enumDefinition.name")
    public abstract EnumValueBean toBean(EnumValue enumValue);

    @Named("getEnumDefinition")
    EnumDefinition getEnumDefinition(String enumDefinitionName) {
        return enumDefinitionDao.findById(enumDefinitionName).orElse(null);
    }

}
