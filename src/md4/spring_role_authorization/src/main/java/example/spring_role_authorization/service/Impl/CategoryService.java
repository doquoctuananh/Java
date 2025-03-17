package example.spring_role_authorization.service.Impl;

import example.spring_role_authorization.model.Category;
import example.spring_role_authorization.repository.ICategoryRepository;
import example.spring_role_authorization.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean createCategory(Category category) {
        boolean result = false;

        result = categoryRepository.save(category) != null;
        return result;
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findCategoryById(long id) {
        return categoryRepository.findById(id).get();
    }
}
