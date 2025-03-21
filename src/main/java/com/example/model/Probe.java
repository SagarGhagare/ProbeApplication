package com.example.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Probe {

    private int x;
    private int y;
    private String direction;
}