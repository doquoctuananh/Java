package example.spring_role_authorization.service;

import example.spring_role_authorization.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    boolean createCategory(Category category);
    void deleteCategory(long id);
    Category findCategoryById(long id);
}
