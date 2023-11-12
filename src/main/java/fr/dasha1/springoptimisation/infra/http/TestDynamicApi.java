package fr.dasha1.springoptimisation.infra.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.dasha1.springoptimisation.domain.model.ToDoItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Constructor;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/dynamic")
public class TestDynamicApi {
    private final ObjectMapper objectMapper;

    public TestDynamicApi(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String testReflection() {
        try {
            Class<?> clazz = Class.forName("fr.dasha1.springoptimisation.domain.model.conveymatrix.ConveyToDoItem");
            final Constructor constructor = clazz.getConstructor(String.class, String.class, String.class,
                    LocalDate.class, boolean.class, boolean.class);
            ToDoItem toDoItem = (ToDoItem) constructor.newInstance("1", "title", "description",
                    LocalDate.now(), true, true);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(toDoItem);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "KO - " + e.getClass().getSimpleName());
        }
    }
}
