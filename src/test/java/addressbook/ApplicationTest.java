package addressbook;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    /*
    @Before
    public void setup() throws Exception {

    }
    */

    @Test
    public void shouldReturnDefaultObject() throws Exception {
        this.mockMvc.perform(get("/book")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("owner", is("Default")));
    }

    @Test
    public void shouldReturnSpecificOwner() throws Exception {
        this.mockMvc.perform(get("/book?owner=Evan")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("owner", is("Evan")));

    }

    @Test
    public void addAndRemove() throws Exception {
        this.mockMvc.perform(get("/book/add?name=TestName&address=Location&number=342-9578")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("size", is(1)));
        this.mockMvc.perform(get("/book/remove?index=0")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("size", is(0)));
    }

}
