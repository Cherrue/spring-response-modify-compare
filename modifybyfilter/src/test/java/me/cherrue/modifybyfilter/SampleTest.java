package me.cherrue.modifybyfilter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StopWatch;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SampleTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @Repeat(100)
    public void test() throws Exception {
        long takedTime = 0L;
        StopWatch sw = new StopWatch();
        mockMvc.perform(get("/filter"))
                .andExpect(status().isOk());

        for(int i=0; i<100; i++) {
            sw.start();
            mockMvc.perform(get("/filter"))
                    .andExpect(status().isOk());
            sw.stop();
            takedTime += sw.getLastTaskTimeNanos();
        }
        System.out.println(takedTime);
    }
}
