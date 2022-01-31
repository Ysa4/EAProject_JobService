package com.jobSearch.jobservice.util;

import com.jobSearch.jobservice.dto.company.Company;
import com.jobSearch.jobservice.dto.user.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;




public class RestTemplateHelper {
    private static RestTemplate restTemplate = new RestTemplate();

    private static final String UserUrl = "http://localhost:8080/users/";
    private static final String companyUrl = "http://localhost:8081/Company/";


    public static User getUser(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<User> responseEntity = restTemplate.exchange(UserUrl + id,HttpMethod.GET, requestEntity, User.class);
        User userBody=responseEntity.getBody();
        return userBody;
    }

    public static Company getCompanyInfo(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Company> responseEntity = restTemplate.exchange(companyUrl +id,HttpMethod.GET, requestEntity, Company.class);
        Company company=responseEntity.getBody();
        return company;
    }

}
