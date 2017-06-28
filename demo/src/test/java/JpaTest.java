import com.zhidian.mam.Application;
import com.zhidian.mam.jpa.repository.UserRepository;
import com.zhidian.mam.jpa.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by zhangjiming on 2017/6/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebAppConfiguration
@Slf4j
public class JpaTest {

    @Autowired
    private IDemoService demoService;

    @Autowired
    private UserRepository userRepository;

    //@Test
    public void testSave() {
        try {
            for(int i=0;i<10;i++) {
                demoService.save("username" + RandomStringUtils.randomNumeric(5), "password" + RandomStringUtils.randomNumeric(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("");
    }

    //@Test
    public void testDelete() {
        try {
            demoService.delete("8a97701a98224347ba22d9a08360df02");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void testUpdate() {
        try {
            demoService.update("3216a393eb0a4ed288359340b0aafb98", "aaaaaaa");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("");
    }

    @Test
    public void findTable() {
        try {
            demoService.findTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
