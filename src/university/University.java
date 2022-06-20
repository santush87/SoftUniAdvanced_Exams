package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int capacity;
    private List<Student> students;

    public University(int capacity) {
        setCapacity(capacity);
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setCapacity(int capacity) {
        if (capacity>0){
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < getCapacity()) {
            if (!this.students.contains(student)){
                this.students.add(student);
               return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                return "Student is already in the university";
            }
        } else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student){
        if (this.students.contains(student)){
            this.students.remove(student);
            return "Removed student " + student.getFirstName() + " " + student.getLastName();
        }else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName){
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return student;
            }
        }
        return null;
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        //"==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
        for (int i = 0; i < this.students.size(); i++) {
            Student student = this.students.get(i);
            builder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",student.getFirstName(), student.getLastName(),student.getBestSubject()));
            if (i < this.students.size()-1){
                builder.append(System.lineSeparator());
            }
        }
        for (Student student : this.students) {
        }

        return builder.toString();
    }

}
