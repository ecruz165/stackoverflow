package com.edwincruz.stackoverflow.mapstructcontext;

import com.edwincruz.stackoverflow.mapstructcontext.model.EnumDefinition;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
public class IEnumDefinitionDao {
    public Optional<EnumDefinition> findById(String enumDefinitionName) {
        return Optional.of(EnumDefinition.builder().name("Mercedes").build());
    }
}
