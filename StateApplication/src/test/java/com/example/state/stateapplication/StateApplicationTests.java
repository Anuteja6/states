package com.example.state.stateapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StateApplicationTests {
    private MockMvc mockMvc;

    @Mock
    private StateService stateService;

    @InjectMocks
    private StateController stateController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(stateController).build();
    }

    @Test
    public void stateControllerTest() throws Exception {
        Mockito.when(stateService.getStates()).thenReturn(new ArrayList<State>());

        mockMvc.perform(MockMvcRequestBuilders.get("/employee/getAllEmployees"))
                .andExpect(status().isOk());
    }
}

}
