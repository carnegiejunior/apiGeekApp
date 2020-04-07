package br.com.geektechnology.chamadostecnicosinternet.tests;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class HttpRequestsTest {

//	@Autowired
//	private MockMvc mockMvc;
	
	@Test
	void whenGeekApp_thenEmptyResponse() throws Exception {
//		this.mockMvc.perform(get("/foos")
//				.andExpect(status().isOk());
	}

}
