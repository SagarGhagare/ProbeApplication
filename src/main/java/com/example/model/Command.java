package com.example.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Command {

    private String action;
    private String direction;

}
