//package com.example.lamba.Lambda;
//
//import com.example.lamba.Entity.Student;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Lambda {
//    static List<Student> list1 = Arrays.asList(new Student("Nguyen Van A", true, 12.0),
//            new Student("Nguyen Van B", false, 10.2),
//            new Student("Tran Thi C", false, 10.0));
//
//
//    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
//        demo4();
//    }
//
//    private static void demo4() {
//        list1.stream().forEach(student -> {
//            student.setMarks(student.getMarks() * 0.5);
//            student.setName(student.getName().toUpperCase());//viết hoa
//            System.out.println(student.getMarks());
//            System.out.println(student.getName());
//        });//duyệt qua các phần tử trong mảng
//        list1.stream().filter(student -> student.getName().startsWith("TRAN")).collect(Collectors.toList()).forEach(student ->
//                System.out.println("Ket Qua " + student.getName()));
//        // filter được sử dụng để lọc các phần tử thỏa mãn collect thu thập các phần tử tìm được thành list
//        List<String> name = list1.stream().filter(student -> student.getMarks() > 5.5).map(student -> student.getName()).collect(Collectors.toList());
//        System.out.println(name);
//        //map su dung de chuyen doi mot phan tu dau vao -> phan tu dau ra VD name -> getName
//        Double tinhDiemTBTatCaHocSinh = list1.stream().map(student -> student.getMarks()).reduce(0.0, (trungGian, PhanTuDuyetQua) -> trungGian += PhanTuDuyetQua / list1.size()).doubleValue();
//        //reduce tính giá trị phần tử tích lũy trong list
//        System.out.println(tinhDiemTBTatCaHocSinh);
//        Student list2 = list1.stream().reduce(list1.get(0),(student, student2) -> {
//            if(student2.getMarks() < student.getMarks()){
//                return student2;
//            }
//            System.out.println(student.getName());
//            return student;
//        });// tim hoc sinh diem thap nhat
//        if(list1.stream().allMatch(student -> student.getMarks() < 100)){
//            System.out.println("Tat ca co diem < 100");
//        }//Tất cả có điểm < 100
//        if(list1.stream().anyMatch(student -> student.getMarks() < 6)){
//            System.out.println("Co it nhat 1 diem  < 6");
//        }// ít nhất 1 có điểm < 100
//        if(list1.stream().noneMatch(student -> student.getMarks() > 10)){
//            System.out.println("Khong co diem > 10");
//        }// không có điểm > 10
//        System.out.println(list1.stream().count()); // ngoại trừ count tất cả sum, min, max, average đều phải quy ra số mapTo...
//        System.out.println(list1.stream().mapToDouble(value -> value.getMarks()).sum());
//        System.out.println(list1.stream().mapToDouble(value -> value.getMarks()).min().orElse(0));
//        //Cách viết khác của lambda
//        Stream.of("lo", "co", "ho").forEach(
//                System.out::println
//        );
//        Stream.of("Gà","Vịt","Ngan","Lơn").map(String::toUpperCase).forEach(System.out::println);
//    }
//
//    private static void demo3() {
//        finalDemo4 dm4 = x -> System.out.println(x);
//        dm4.m1(120000);
//    }
//
//    private static void demo2() {
//        Collections.sort(list1, (sv1, sv2) -> sv1.getMarks().compareTo(sv2.getMarks()));
//        list1.forEach(student -> {
//            System.out.println("Name: " + student.getName());
//            System.out.println("Gender: " + student.isGender());
//            System.out.println("Mark: " + student.getMarks());
//        });
//    }
//
//    private static void demo1() {
//        List<Integer> list = Arrays.asList(1, 4, 5, 7);
//        list.forEach(integer -> System.out.println(integer));
//        list1.forEach(student ->
//        {
//            System.out.println("Name: " + student.getName());
//            System.out.println("Gender: " + student.isGender());
//            System.out.println("Mark: " + student.getMarks());
//        });
//    }
//
//
//}
//
//@FunctionalInterface
//interface finalDemo4 {
//    void m1(int x);
//
//    default void m2() {
//    }
//
//    public static void m3() {
//    }
//}
//
