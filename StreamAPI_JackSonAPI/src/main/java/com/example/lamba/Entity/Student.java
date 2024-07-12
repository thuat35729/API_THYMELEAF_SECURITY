package com.example.lamba.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    String name;
    boolean gender = false;
    Double marks = 0.0;
    Contact contact;
    List<String> subjects;
}
