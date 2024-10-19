package module2.test.service;

import module2.test.model.Teacher;

public interface ITeacher extends IPerson<Teacher> {
    void tech(Teacher teacher);
    void salary(Teacher teacher);
}
