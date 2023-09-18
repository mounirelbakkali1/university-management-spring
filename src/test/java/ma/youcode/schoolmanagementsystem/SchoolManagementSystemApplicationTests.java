package ma.youcode.schoolmanagementsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestEnvironmentConfiguration.class)
class SchoolManagementSystemApplicationTests {

	@Test
	void contextLoads() {
	}

}
