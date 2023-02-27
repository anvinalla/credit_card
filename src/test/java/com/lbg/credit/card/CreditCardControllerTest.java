package com.lbg.credit.card;

import com.lbg.credit.card.service.CreditCardService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ActiveProfiles("test")
@TestConfiguration
public class CreditCardControllerTest extends ApplicationTests{

    @Mock
    CreditCardService creditCardService;

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public  void setup(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void test_add_account_api() throws Exception {
        //Given
        String mockAdd = "{\"name\":\"TestUser\",\"accNo\":\"12345678\",\"srcCode\":\"121212\",\"PAN\":\"1234123412340980\"}";

        String response= "{\"name\":\"TestUser\",\"status\":true,\"PAN\":\"1234xxxxxxxx0980\"}";

        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/addAccount")
                .contentType(MediaType.APPLICATION_JSON).content(mockAdd).accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();

        //then
        assertThat(result).isEqualTo(response);
    }
}
