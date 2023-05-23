package com.eample.footprint;

import org.springframework.data.annotation.Id;

public record User(@Id Long id, String name, String height, double weight, String diet, String lifestyle) {
    
}
