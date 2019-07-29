package com.yunus.bagriyanik.web;

import com.yunus.bagriyanik.model.DataModel;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RESTApiTest {

  private RestTemplate restTemplate;

  // before each test methods working, runs the code inside
  // initializing test method
  @Before
  public void setUp(){
    restTemplate = new RestTemplate();
  }

  // test methods shouldn't take input arguments
  @Test
  public void testGetDataModelById(){
    ResponseEntity<DataModel> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/datamodel/4342", DataModel.class);
    MatcherAssert.assertThat(responseEntity.getStatusCodeValue(), Matchers.equalTo(200));
    MatcherAssert.assertThat(responseEntity.getBody().getModelName(), Matchers.equalTo("Model I TEST"));
  }
}
