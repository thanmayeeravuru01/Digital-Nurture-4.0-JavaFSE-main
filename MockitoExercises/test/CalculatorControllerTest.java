import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CalculatorControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new CalculatorController()).build();
    }

    @Test
    public void testDivide() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "10")
                        .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    public void testDivideByZero() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "10")
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cannot divide by zero"));
    }
    @Test
    public void testMod() throws Exception {
        mockMvc.perform(get("/mod")
                        .param("a", "10")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void testModByZero() throws Exception {
        mockMvc.perform(get("/mod")
                        .param("a", "10")
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cannot perform modulus by zero"));
    }
    @Test
    public void testSquare() throws Exception {
        mockMvc.perform(get("/square")
                        .param("a", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("25"));
    }
    @Test
    public void testPower() throws Exception {
        mockMvc.perform(get("/power")
                        .param("a", "2")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8"));
    }
    @Test
    public void testModulus() throws Exception {
        mockMvc.perform(get("/modulus")
                        .param("a", "10")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }
    @Test
    public void testModulusByZero() throws Exception {
        mockMvc.perform(get("/modulus")
                        .param("a", "10")
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cannot divide by zero"));
    }
    @Test
    public void testNegate() throws Exception {
        mockMvc.perform(get("/negate")
                        .param("a", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("-5"));
    }


}
