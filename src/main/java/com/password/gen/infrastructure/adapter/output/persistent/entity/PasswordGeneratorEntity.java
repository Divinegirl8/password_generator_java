package com.password.gen.infrastructure.adapter.output.persistent.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

@Document
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PasswordGeneratorEntity {
    @Id
    private String id;
    @Field
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXXXX'['VV']'")
    private LocalDateTime localDateTime;
}
