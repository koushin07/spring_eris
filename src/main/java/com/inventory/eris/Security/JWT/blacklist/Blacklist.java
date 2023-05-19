package com.inventory.eris.Security.JWT.blacklist;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
class Blacklist {

    private String accessToken;

    private String refreshToken;

    private LocalDateTime createdAt;
}