package com.crc.leasing.domain.model.office;

import com.crc.leasing.domain.model.Address;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Office {
    final String domainId;
    final Address address;
    final String websiteUrl;
    final String officeCeo;
    boolean deleted;

    public void markAsDelete() {
        deleted = true;
    }
}
