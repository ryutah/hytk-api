import org.junit.Before;
import org.junit.Test;
import services.impl.TagDataServiceImpl;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

/**
 * Created by ryuta on 15/01/18.
 */
public class TagDataServiceImplTest {
    TagDataServiceImpl tagDataService = new TagDataServiceImpl();

    @Before
    public void setUp() {

    }

    @Test
    public void saveTagTest() {
        running(fakeApplication(inMemoryDatabase("default")), () -> {
            String tag = "newTag";

            long id = tagDataService.saveTag(tag);

            assertThat(id).isEqualTo(1);
        });

    }
}
