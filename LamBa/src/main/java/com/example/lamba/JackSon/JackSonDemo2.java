package com.example.lamba.JackSon;

import com.example.lamba.Entity.Contact;
import com.example.lamba.Entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JackSonDemo2 {
    public static void main(String[] args) throws Exception {
        JackSonDemoS();
        JackSonDemoL();
        JackSonDemoC();
        JackSonDemoM();
        JackSonDemoE();
    }

    private static void JackSonDemoE() throws Exception {
        Contact contact = new Contact("QQ@gmail.com", "0123456789");
        List<String> subjects = Arrays.asList("WEB LIAW", "COM123");
        Student st = new Student("Minh Bo 2", false, 12.3, contact, subjects);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(st);
        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, st);// làm đẹp
        mapper.writeValue(new File("C:\\Users\\Dell\\Desktop\\note\\studentes.json"), st);
    }

    private static void JackSonDemoM() throws Exception {
        Map<String, Object> contact = new HashMap<String, Object>();
        contact.put("mail", "Queo@gmail.com");
        contact.put("phone", "0812313123");
        List<String> subjects = Arrays.asList("WEB1013", "COM8080");
        Map<String, Object> student = new HashMap<String, Object>();
        student.put("name", "Nguyen Van Queo");
        student.put("marks", 12.9);
        student.put("gender", false);
        student.put("contact", contact);
        student.put("subjects", subjects);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student);
        System.out.println(json);
        mapper.writeValue(System.out, student);
        mapper.writeValue(new File("C:\\Users\\Dell\\Desktop\\note\\students.json"), student);
    }

    private static void JackSonDemoC() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Dau Xanh");
        student.put("marks", 7.8);
        student.put("gender", false);
        ObjectNode contact = student.putObject("contact");
        contact.put("email", "MinhBo@gmail.com");
        contact.put("phone", "0940219312");
        ArrayNode subject = student.putArray("subjects");
        subject.add("WEB 2627");
        subject.add("COM 1808");
        //Viết vào json
        String json = mapper.writeValueAsString(student);
        //Gửi đến nơi nào đó (ghi output)
        mapper.writeValue(System.out, student);
        //Viết vào file
        mapper.writeValue(new File("C:\\Users\\Dell\\Desktop\\note\\student.json"), student);

    }

    private static void JackSonDemoL() throws Exception {
        String path = "D:\\Java6\\LamBa\\src\\main\\resources\\Student.json";
        TypeReference<List<Student>> type = new TypeReference<List<Student>>() {
        };
        ObjectMapper mapper = new ObjectMapper();
        List<Student> student = mapper.readValue(new File(path), type);
        student.forEach(student1 -> {
            System.out.println(">> Name" + student1.getName());
        });
        student.forEach(student1 -> {
            System.out.println(">> Gender" + student1.isGender());
        });
        student.forEach(student1 -> {
            System.out.println(">> Marks" + student1.getMarks());
        });
        student.stream().map(contact -> contact.getContact()).forEach(cont -> {
            System.out.println("> Email" + cont.getEmail());
            System.out.println("> Phone" + cont.getPhone());
        });
        List<String> subjects = student.stream().flatMap(subject -> subject.getSubjects().stream()).collect(Collectors.toList());
        subjects.forEach(s -> {
            System.out.println("> Subject:" + s);
        });

    }

    private static void JackSonDemoS() throws Exception {
        String path = "D:\\Java6\\LamBa\\src\\main\\resources\\Students.json";
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(new File(path), Student.class);
        System.out.println(">> Name" + student.getName());
        System.out.println("> Gender" + student.isGender());
        System.out.println("> Marks" + student.getMarks());
        Contact contact = student.getContact();
        System.out.println("> Email" + contact.getEmail());
        System.out.println("> Phone" + contact.getPhone());
        List<String> subjects = student.getSubjects();
        subjects.forEach(sub -> {
            System.out.println(">> Subject:" + sub);
        });
    }


}
