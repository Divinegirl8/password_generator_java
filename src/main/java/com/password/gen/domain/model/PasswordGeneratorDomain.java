package com.password.gen.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PasswordGeneratorDomain {
    private String id;
    private String password;
    private String length;
    private LocalDateTime localDateTime;
}
