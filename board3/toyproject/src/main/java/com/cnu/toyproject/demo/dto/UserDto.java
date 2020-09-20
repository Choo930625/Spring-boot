package com.cnu.toyproject.demo.dto;

import com.cnu.toyproject.demo.domain.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String password;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public UserDto(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
