package homework5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import homework4.Gender;
import homework4.Group;
import homework4.Student;
import homework8.EnhancedGroup;

public class GroupFileStorage {

    public static void saveGroupToCSV(Group group) {
        saveGroupToCSV(group.getGroupName(), Arrays.asList(group.getStudents()));
    }

    public static void saveGroupToCSV(EnhancedGroup group) {
        saveGroupToCSV(group.getGroupName(), group.getStudents());
    }


    private static void saveGroupToCSV(String groupName, List<Student> students) {
        String fileName = "Homework OOP 4\\src\\files\\" + groupName + ".csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write the header
            writer.write("Id,Name,Last name, Gender, Group");
            writer.newLine();

            // Write the data for each person
            for (Student student : students) {
                writer.write(student.getId() + ",");
                writer.write(student.getName() + ",");
                writer.write(student.getLastName() + ",");
                writer.write(student.getGender().toString() + ",");
                writer.write(student.getGroupName());
                writer.newLine();
            }

            writer.close();

            System.out.println("CSV file has been written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Group loadGroupFromCSV(File file) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            List<Student> students = new ArrayList<>();

            // Skip the header row
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String lastName = data[2];
                Gender gender = Gender.valueOf(data[3]);
                String groupName = data[4];
                Student student = new Student(name, lastName, gender, id, groupName);
                students.add(student);
            }

            return new Group(file.getName(), students.toArray(new Student[0]));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File findFileByGroupName(String groupName, File workFolder) {
        String fileName = groupName + ".csv";
        if (workFolder.exists()) {
            return searchFile(workFolder, fileName);
        } else {
            System.out.println("Folder does not exist.");
            return null;
        }
    }

    private static File searchFile(File folder, String fileName) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFile(file, fileName); // Recursively search subfolders
                } else if (file.getName().equalsIgnoreCase(fileName)) {
                    System.out.println("Found file!");
                    return file;
                }
            }
        }
        return null;
    }

}