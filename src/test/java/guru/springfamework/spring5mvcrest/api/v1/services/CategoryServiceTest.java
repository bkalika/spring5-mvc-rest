package guru.springfamework.spring5mvcrest.api.v1.services;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.services.CategoryService;
import guru.springfamework.services.CategoryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by bogdan.kalika@gmail.com
 * Date: 5/8/2024
 */
public class CategoryServiceTest {

    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    public void getAllCategories() {
        // given
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());

        when(categoryRepository.findAll()).thenReturn(categories);

        // when
        List<CategoryDTO> categoryDTOs = categoryService.getAllCategories();

        // then
        assertEquals(3, categoryDTOs.size());
    }

    @Test
    public void getCategoryByName() {
        // given
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when((categoryRepository.findByName(anyString()))).thenReturn(category);

        // when
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);

        // then
        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }
}
