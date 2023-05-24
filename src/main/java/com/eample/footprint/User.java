package com.eample.footprint;

import org.springframework.data.annotation.Id;

public record User(String name, String height, double weight, String diet, String lifestyle) {
    
}
