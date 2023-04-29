package com.edwincruz.stackoverflow.mapstructcontext.mapper;

import com.edwincruz.stackoverflow.mapstructcontext.IEnumDefinitionDao;
import com.edwincruz.stackoverflow.mapstructcontext.model.EnumDefinition;
import com.edwincruz.stackoverflow.mapstructcontext.model.EnumValue;
import com.edwincruz.stackoverflow.mapstructcontext.model.EnumValueBean;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface EnumValueMapperWithContext {

    @Mapping(target = "enumDefinition", source = "enumDefinitionId", qualifiedByName = "getEnumDefinition")
    EnumValue toEntity(EnumValueBean enumValueBean, @Context IEnumDefinitionDao enumDefinitionDao);

    @Mapping(target = "enumDefinitionId", source = "enumDefinition.name")
    EnumValueBean toBean(EnumValue enumValue);

    @Named("getEnumDefinition")
    default EnumDefinition getEnumDefinition(String enumDefinitionName, @Context IEnumDefinitionDao enumDefinitionDao) {
        return enumDefinitionDao.findById(enumDefinitionName).orElse(null);
    }

}
