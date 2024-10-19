package module2.test.service;

import module2.test.model.Student;

public interface IStudent extends IPerson<Student> {
    void learn(Student student);
}
