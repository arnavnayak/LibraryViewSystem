package com.view.library.librarysystem.libraryviewsystem.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.view.library.librarysystem.libraryviewsystem.api.integration.LibraryBookEntryIntegrationRequest;
import com.view.library.librarysystem.libraryviewsystem.models.api.LibraryBookEntryViewResponse;
import com.view.library.librarysystem.libraryviewsystem.models.api.LibraryBookViewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.DataInput;
import java.util.List;

@Service
public class LibraryViewService {

    @Autowired
    RestTemplate restTemplate;

    public LibraryBookEntryViewResponse libraryBookEntryIntegrationServiceCall(String integrationUrl, HttpMethod post, HttpEntity<LibraryBookEntryIntegrationRequest> entity, Class<String> libraryBookEntryIntegrationResponse){
        ResponseEntity<String> integrationResponse = restTemplate.exchange(integrationUrl, post, entity, libraryBookEntryIntegrationResponse);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert the JSON string into a List of LibraryBookViewResponse objects
            LibraryBookViewResponse response = objectMapper.readValue(integrationResponse.getBody(), LibraryBookViewResponse.class);
            return new LibraryBookEntryViewResponse().addLibraryBookEntriesItem(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public LibraryBookEntryViewResponse getAllLibraryBookEntriesIntegrationServiceCall(String integrationUrl, HttpMethod get, HttpEntity<LibraryBookEntryIntegrationRequest> entity,Class<String> libraryBookEntryIntegrationResponse){
        ResponseEntity<String> integrationResponse = restTemplate.exchange(integrationUrl, get, entity,libraryBookEntryIntegrationResponse);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert the JSON string into a List of LibraryBookViewResponse objects
            List<LibraryBookViewResponse> bookEntriesResponse = objectMapper.readValue(integrationResponse.getBody(),new TypeReference<List<LibraryBookViewResponse>>() {});;
            return new LibraryBookEntryViewResponse().libraryBookEntries(bookEntriesResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResponseEntity<String> getSpecificLibraryBookEntryByIdIntegrationServiceCall(String integrationUrl, HttpMethod get, HttpEntity<LibraryBookEntryIntegrationRequest> entity,Class<String> libraryBookEntryIntegrationResponse) {
        return restTemplate.exchange(integrationUrl, get, entity,libraryBookEntryIntegrationResponse);
    }

    public ResponseEntity<String> deleteLibraryBookEntryByIdIntegrationServiceCall(String integrationUrl, HttpMethod delete, HttpEntity<LibraryBookEntryIntegrationRequest> entity,Class<String> libraryBookEntryIntegrationResponse) {
        return restTemplate.exchange(integrationUrl, delete, entity,libraryBookEntryIntegrationResponse);
    }

    public ResponseEntity<String> libraryBookEntryUpdateIntegrationServiceCall(String integrationUrl, HttpMethod put, HttpEntity<LibraryBookEntryIntegrationRequest> entity,Class<String> libraryBookEntryIntegrationResponse) {
        return restTemplate.exchange(integrationUrl, put, entity,libraryBookEntryIntegrationResponse);
    }
}
