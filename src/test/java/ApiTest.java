import adapters.ProjectAdapter;
import models.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ApiTest {
    @Test (description = "Negative test for Create new project. Using an invalid value for the 'Code' field")
    public void negativeApiTest() {
        Project project = Project.builder().
                title("blabla").
                code("!!").
                build();
        ResponseStatusNegative actual = new ProjectAdapter().postProject(project, 422);
        ResponseStatusNegative expected = ResponseStatusNegative.builder()
                .status(false)
                .errorMessage("Data is invalid.")
                .build();

        assertEquals(actual, expected);
//        assertEquals(actual.isStatus(), expected.isStatus());
//        assertEquals(actual.getErrorMessage(), expected.getErrorMessage());
    }
 }
