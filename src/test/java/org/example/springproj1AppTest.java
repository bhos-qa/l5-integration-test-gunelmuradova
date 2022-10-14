package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class springproj1AppTest {

    public void integrationTest(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertNotNull(response);
        assertTrue(response.getStatusCode() == HttpStatus.OK);
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
    }
    @DisplayName("1. Int. Test")
    @Test
    public void checkSuccessfulJsonResponseRepos() {
        integrationTest("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos");
    }

    @DisplayName("2. Int. Test")
    @Test
    public void checkSuccessfulJsonResponseBranches() {
        integrationTest("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos/1/branches");
    }

    @DisplayName("3. Int. Test")
    @Test
    public void checkSuccessfulJsonResponseCommits() {
        integrationTest("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos/1/branches/1/commits");
    }


}