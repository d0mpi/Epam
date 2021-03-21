package com.epam.jwd.app;
import com.epam.jwd.model.Student;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student(123,"Michael", "BSU"));
        arrayList.add(new Student(54984,"Nikita", "BSUIR"));
        arrayList.add(new Student(268465,"John", "BNTU"));


        for(Student student : arrayList) {
            logger.info(student.toString());
        }
    }
}