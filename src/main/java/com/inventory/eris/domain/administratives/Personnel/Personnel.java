package com.inventory.eris.domain.administratives.Personnel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Personnel {

    private Long personnelId;
    private String firstName;
    private String lastName;
    private String suffix;
    private String middleName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deleteAt;

}
