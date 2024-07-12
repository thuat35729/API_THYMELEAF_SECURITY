package com.example.lamba.JackSon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JackSonDemo {
    public static void main(String[] args) throws Exception {
        demoJS();
        demoJS2();
    }

    private static void demoJS2() throws Exception {
        String path = "D:\\Java6\\StreamAPI_JackSonAPI\\src\\main\\resources\\Student.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode students = mapper.readTree(new File(path));
        for (JsonNode student: students
             ) {
            System.out.println("> Name" + student.get("name").asText());
            System.out.println("> Gender" + student.get("gender").asBoolean());
            System.out.println("> Marks" + student.get("marks").asDouble());
            System.out.println("> Email" + student.get("contact").get("email").asText());
            System.out.println("> Phone" + student.findValue("phone").asText());
            student.get("subjects").forEach(subject2 -> {
                    System.out.println("SUBJECTS ==" + subject2.asText());

            });
        }
    }

    private static void demoJS() throws Exception {
        String json = "{\r\n" +
                "\"name\": \"Nguyễn Văn Tèo\",\r\n" +
                "\"gender\": true,\r\n" +
                "\"marks\": 7.5,\r\n" +
                "\"contact\": {\r\n" +
                "\"email\": \"teonv@gmail.com\",\r\n" +
                "\"phone\":\"0913745789\"\r\n" +
                "},\r\n" +
                "\"subjects\":[\"WEB205\", \"COM 108\"]\r\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(json);
        System.out.println("> Name" + student.get("name").asText());
        System.out.println("> Gender" + student.get("gender").asBoolean());
        System.out.println("> Marks" + student.get("marks").asDouble());
        System.out.println("> Email" + student.get("contact").get("email").asText());
        System.out.println("> Phone" + student.findValue("phone").asText());
        student.get("subjects").iterator().forEachRemaining(subject -> {
            System.out.println("> Subjects" + subject.asText());
        });
    }
}
