package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository
{
    HashMap<String, Student> studentDb = new HashMap<>();
    HashMap<String, Teacher> teacherDb = new HashMap<>();

    HashMap<String, List<String>> teacherStudentDb = new HashMap<>();
    HashMap<String, String > studentTeacherJoin = new HashMap<>();


    public void addStudent (Student student) {studentDb.put(student.getName(), student); }

    /**
     * @param teacher
     */
    public void addTeacher(Teacher teacher) {teacherDb.put(teacher.getName(), teacher);}

    public void addStudentTeacherPair (String studentName, String teacherName)
    {
        List<String> studentCombination = new ArrayList<>();

        if (studentDb.containsKey(studentName) && teacherDb.containsKey(teacherName))
        {
            if (teacherStudentDb.containsKey(teacherName)) studentCombination = teacherStudentDb.get(teacherName);
            studentCombination.add(studentName);

            teacherStudentDb.put(teacherName,studentCombination);

            studentTeacherJoin.put(studentName, teacherName);

            //For particular Teacher, how many student he is teaching
            Teacher t = teacherDb.get(teacherName);
            t.setNumberOfStudents(studentCombination.size());
        }
    }


    public Student getStudentByName(String name)
    {
        return studentDb.get(name);
    }

    public Teacher getTeacherByName(String name)
    {
        return teacherDb.get(name);
    }

    /**
     *
     * @param teacherName
     * @return
     */
    public List<String> getStudentsByTeacherName(String teacherName)
    {
        List<String> studentList = new ArrayList<>();
        if (teacherStudentDb.containsKey(teacherName)) studentList = teacherStudentDb.get(teacherName);
        return studentList;
    }

    public List<String> getAllStudent() {return new ArrayList<>(studentDb.keySet());}


    public void deleteTeacherByName(String teacher)
    {
        if (teacherStudentDb.containsKey(teacher) && teacherDb.containsKey(teacher))
        {
            teacherDb.remove(teacher);
            teacherStudentDb.remove(teacher);
        }
        if (studentTeacherJoin.containsKey(teacher)) studentTeacherJoin.remove(teacher);
    }

    public void deleteAllTeachers()
    {
        for(String teacher : teacherDb.keySet())
        {
            if (teacherStudentDb.containsKey(teacher)) teacherStudentDb.remove(teacher);
            if (studentTeacherJoin.containsKey(teacher)) studentTeacherJoin.remove(teacher);

            teacherDb.remove(teacher);
        }
    }
}
