package com.edwincruz.stackoverflow.mapstructcontext.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class EnumDefinition {
    String name;
}
