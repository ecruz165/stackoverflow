package com.edwincruz.stackoverflow.mapstructcontext;

import com.edwincruz.stackoverflow.mapstructcontext.model.EnumValueBean;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DefinitionServiceTest {

    @Autowired
    DefinitionService definitionService;

    @Test
    void doLookupUsingContextApproach() {
        val input = EnumValueBean.builder().enumDefinitionId(Integer.MAX_VALUE).build();
        definitionService.doLookupUsingContextApproach(input);
    }

    @Test
    void doLookupUsingAutowireBeanApproach() {
        val input = EnumValueBean.builder().enumDefinitionId(Integer.MAX_VALUE).build();
        definitionService.doLookupUsingAutowireBeanApproach(input);
    }
}