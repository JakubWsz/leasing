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
    final String uuid;
    Address address;
    String websiteUrl;
    String officeCeo;
    boolean deleted;

    public Office(String uuid) {
        this.uuid = uuid;
    }

    public void markAsDelete() {
        deleted = true;
    }
}
