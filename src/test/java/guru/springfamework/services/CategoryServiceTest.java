package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {
    public static final String NAME = "Apple";
    public static final long ID = 2L;
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        //  initialiser les objets simulés (mocks) dans une classe de test.
        MockitoAnnotations.initMocks(this);

        // SetUp our Mapper
        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    public void getAllCategories() {
        // Given
        List<Category> categories = Arrays.asList(new Category(),new Category(),new Category());
        when(categoryRepository.findAll()).thenReturn(categories);

        // When
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

        // Then
        assertEquals(3,categoryDTOS.size());
    }

    @Test
    public void getCategoryByName() {
        // Given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        // When
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);

        // Then
//        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME,categoryDTO.getName());
    }
}
