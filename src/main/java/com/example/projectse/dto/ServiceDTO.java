package com.example.projectse.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceDTO {
    private Long id;
    private String name;
    private int code;
    private int type;
}
