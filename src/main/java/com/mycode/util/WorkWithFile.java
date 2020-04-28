package com.mycode.util;

import com.mycode.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WorkWithFile {

    static String filePath = "src/main/resources/templates/file/data.txt";

    public static void write(User user) throws IOException {
        FileWriter writer = new FileWriter(filePath, true);

        writer.append( user.toString());
        writer.append('\n');
        writer.flush();
        writer.close();
    }

    private static String  findLineByName( String firstName, String lastName) {

        List<String> lines = null;
        try {
            lines = Files.lines(Paths.get(filePath)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line: lines){
          if (line.contains(lastName) && line.contains(firstName)){
              return line;
          }
      }
        return null;
    }

    public static User findPerson(String firstName, String lastName) {
        String person = findLineByName(firstName, lastName);
        if (person==null) return null;

        User user  = mapToUser(person);
       return user;
    }

    private static User mapToUser(String person) {
        User user = new User();
        List<String> list = Arrays.asList(person.split(" "));
        user.setLastName(list.get(0));
        user.setFirstName(list.get(1));
        user.setMiddleName(list.get(2));
        user.setAge(Integer.valueOf(list.get(3)));
        user.setSalary(Integer.valueOf(list.get(4)));
        user.setEmail(list.get(5));
        user.setPlaceOfWork(list.get(6));
        return user;
    }


    public static List<User> readUserFromTheFile() {
        List<User> users = null;
        try {
            users = Files.lines(Paths.get(filePath)).map(WorkWithFile::mapToUser).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users != null ? users : new ArrayList<>();
    }
}
