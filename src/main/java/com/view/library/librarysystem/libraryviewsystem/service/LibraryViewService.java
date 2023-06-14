package com.view.library.librarysystem.libraryviewsystem.service;

import com.view.library.librarysystem.libraryviewsystem.api.integration.LibraryBookEntryIntegrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibraryViewService {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<String> libraryBookEntryIntegrationServiceCall(String integrationUrl, HttpMethod post, HttpEntity<LibraryBookEntryIntegrationRequest> entity,Class<String> libraryBookEntryIntegrationResponse){
        return restTemplate.exchange(integrationUrl, post, entity,libraryBookEntryIntegrationResponse);
    }

    public ResponseEntity<String> getAllLibraryBookEntriesIntegrationServiceCall(String integrationUrl, HttpMethod get, HttpEntity<LibraryBookEntryIntegrationRequest> entity,Class<String> libraryBookEntryIntegrationResponse){
        return restTemplate.exchange(integrationUrl, get, entity,libraryBookEntryIntegrationResponse);
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
