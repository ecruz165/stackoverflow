package com.edwincruz.stackoverflow.mapstructcontext;

import com.edwincruz.stackoverflow.mapstructcontext.mapper.EnumValueMapperWithAutowiredBean;
import com.edwincruz.stackoverflow.mapstructcontext.mapper.EnumValueMapperWithContext;
import com.edwincruz.stackoverflow.mapstructcontext.model.EnumValue;
import com.edwincruz.stackoverflow.mapstructcontext.model.EnumValueBean;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefinitionService {

    // Autowire Bean Approach
    private final EnumValueMapperWithAutowiredBean enumValueMapperWithAutowiredBean;

    // Context Approach
    private final IEnumDefinitionDao enumDefinitionDao;
    private final EnumValueMapperWithContext enumValueMapperWithContext;

    public EnumValue doLookupUsingContextApproach(EnumValueBean bean) {
        return enumValueMapperWithContext.toEntity(bean, enumDefinitionDao);
    }

    public EnumValue doLookupUsingAutowireBeanApproach(EnumValueBean bean) {
        return enumValueMapperWithAutowiredBean.toEntity(bean);
    }

}
