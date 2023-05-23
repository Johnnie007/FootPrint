package com.eample.footprint;
import org.springframework.data.annotation.Id;

public record FootPrint(@Id Long id, User user) {

}
