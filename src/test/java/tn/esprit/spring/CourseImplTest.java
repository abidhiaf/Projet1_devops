package tn.esprit.spring;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.services.ICourseServices;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseImplTest {

    @Autowired
    private ICourseServices courseService;

    @Test
    @Order(1)
    public void testAddCourse() {
        // Créez un nouvel objet Course pour tester
        Course course = new Course();
        course.setLevel(1);
        course.setTypeCourse(TypeCourse.MATH); // Remplacez MATH par le type de cours que vous voulez tester
        course.setSupport(Support.PAPER); // Remplacez PAPER par le support que vous voulez tester
        course.setPrice(50.0f); // Remplacez 50.0f par le prix que vous voulez tester
        course.setTimeSlot(60); // Remplacez 60 par le créneau horaire que vous voulez tester


        Course savedCourse = courseService.addCourse(course);


        Assertions.assertNotNull(savedCourse.getNumCourse());


        Assertions.assertEquals(course.getLevel(), savedCourse.getLevel());
        Assertions.assertEquals(course.getTypeCourse(), savedCourse.getTypeCourse());
        Assertions.assertEquals(course.getSupport(), savedCourse.getSupport());
        Assertions.assertEquals(course.getPrice(), savedCourse.getPrice(), 0.001); // Utilisez une tolérance pour les valeurs flottantes
        Assertions.assertEquals(course.getTimeSlot(), savedCourse.getTimeSlot());

        // Journalisez le résultat (en option)
        log.info("Cours enregistré : " + savedCourse);
    }
}
