package tn.esprit.spring;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.CourseServicesImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseImplMockito {

    @InjectMocks
    private CourseServicesImpl courseService;

    @Mock
    private ICourseRepository courseRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    public void testAddCourse() {
        // Créez un nouvel objet Course pour tester
        Course course = new Course();
        course.setLevel(1);
        course.setTypeCourse(TypeCourse.MATH);
        course.setSupport(Support.PAPER);
        course.setPrice(50.0f);
        course.setTimeSlot(60);

        // Configurez le mock du repository pour simuler le comportement
        // Configurez le mock du repository pour simuler le comportement
        Mockito.when(courseRepository.save(Mockito.any(Course.class))).thenAnswer(invocation -> {
            Course courseToSave = invocation.getArgument(0);
            courseToSave.setNumCourse(1L); // Simulez l'attribution d'un ID
            return courseToSave;
        });


        Course savedCourse = courseService.addCourse(course);

        Assertions.assertNotNull(savedCourse.getNumCourse());
        Assertions.assertEquals(course.getLevel(), savedCourse.getLevel());
        Assertions.assertEquals(course.getTypeCourse(), savedCourse.getTypeCourse());
        Assertions.assertEquals(course.getSupport(), savedCourse.getSupport());
        Assertions.assertEquals(course.getPrice(), savedCourse.getPrice(), 0.001);
        Assertions.assertEquals(course.getTimeSlot(), savedCourse.getTimeSlot());
    }
}
