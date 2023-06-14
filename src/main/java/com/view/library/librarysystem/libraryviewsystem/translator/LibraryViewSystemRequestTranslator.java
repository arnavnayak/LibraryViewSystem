package com.view.library.librarysystem.libraryviewsystem.translator;

import com.view.library.librarysystem.libraryviewsystem.api.integration.LibraryBookEntryIntegrationRequest;
import com.view.library.librarysystem.libraryviewsystem.api.view.LibraryBookEntryViewRequest;
import com.view.library.librarysystem.libraryviewsystem.service.LibraryViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class LibraryViewSystemRequestTranslator {


    public static final String RENTED = "RENTED";

//    @Autowired
//    LoadBalancerClient ribbonLoadBalancerClient;

    @Autowired
    LibraryViewService libraryViewService;

    public ResponseEntity<String> libraryBookEntryViewRequestTranslator(LibraryBookEntryViewRequest libraryBookEntryViewRequest,String pathParam) {
        String integrationServiceName="http://localhost:8081/";
        String integrationServiceEndpoint="library/books/integration/bookEntry";
        LibraryBookEntryIntegrationRequest libraryBookEntryIntegrationRequest = createBookEntryIntegrationRequest(libraryBookEntryViewRequest);
        String integrationServiceUrl=createIntegrationServiceUrl(integrationServiceName,integrationServiceEndpoint,pathParam);
        HttpEntity<LibraryBookEntryIntegrationRequest> entity = new HttpEntity<>(libraryBookEntryIntegrationRequest);
        return libraryViewService.libraryBookEntryIntegrationServiceCall(integrationServiceUrl, HttpMethod.POST,entity,String.class);
    }

    public ResponseEntity<String> getAllLibraryBookEntriesViewRequestTranslator(String pathParam){
        String integrationServiceName="http://localhost:8081/";
        String integrationServiceEndpoint="library/books/integration/fetchAllBook";
        String integrationServiceUrl=createIntegrationServiceUrl(integrationServiceName,integrationServiceEndpoint,pathParam);
        return libraryViewService.getAllLibraryBookEntriesIntegrationServiceCall(integrationServiceUrl, HttpMethod.GET,null,String.class);
    }
    private String createIntegrationServiceUrl(String integrationServiceName, String integrationServiceEndpoint,String pathParam) {
        String url=integrationServiceName.concat(integrationServiceEndpoint);
        if(pathParam != null) {
            url = url+"/"+(pathParam);
        }
//        ServiceInstance instance=this.ribbonLoadBalancerClient.choose(integrationServiceName)
//        if(null!=instance) {
//            url=instance.getUri().toString().concat(integrationServiceEndpoint);
//        }
        return url;
    }

    private LibraryBookEntryIntegrationRequest createBookEntryIntegrationRequest(LibraryBookEntryViewRequest libraryBookEntryViewRequest) {
        LibraryBookEntryIntegrationRequest libraryBookEntryIntegrationRequest = new LibraryBookEntryIntegrationRequest();
        if(libraryBookEntryViewRequest != null && libraryBookEntryViewRequest.getLastName() != null) {
            libraryBookEntryIntegrationRequest.setPersonName(libraryBookEntryViewRequest.getFirstName()+" "+libraryBookEntryViewRequest.getLastName());
        }else {
            libraryBookEntryIntegrationRequest.setPersonName(libraryBookEntryViewRequest.getFirstName());
        }
        libraryBookEntryIntegrationRequest.setPersonEmail(libraryBookEntryViewRequest.getEmail());
        libraryBookEntryIntegrationRequest.setBookNameAndAuthorName(libraryBookEntryViewRequest.getBookName()+" by "+ libraryBookEntryViewRequest.getAuthorName());
        libraryBookEntryIntegrationRequest.setBookStatus(RENTED);
        libraryBookEntryIntegrationRequest.setDateUpdated(LocalDate.now());
        return libraryBookEntryIntegrationRequest;
    }

    public ResponseEntity<String> getBookByIdViewRequestTranslator(String pathParam) {
        String integrationServiceName="http://localhost:8081/";
        String integrationServiceEndpoint="library/books/integration/fetchBookById";
        String integrationServiceUrl=createIntegrationServiceUrl(integrationServiceName,integrationServiceEndpoint,pathParam);
        return libraryViewService.getSpecificLibraryBookEntryByIdIntegrationServiceCall(integrationServiceUrl, HttpMethod.GET,null,String.class);
    }

    public ResponseEntity<String> deleteBookByIdViewRequestTranslator(String pathParam) {
        String integrationServiceName="http://localhost:8081/";
        String integrationServiceEndpoint="library/books/integration/deleteBookEntry";
        String integrationServiceUrl=createIntegrationServiceUrl(integrationServiceName,integrationServiceEndpoint,pathParam);
        return libraryViewService.deleteLibraryBookEntryByIdIntegrationServiceCall(integrationServiceUrl, HttpMethod.DELETE,null,String.class);
    }

    public ResponseEntity<String> updateBookEntryViewRequestTranslator(LibraryBookEntryViewRequest libraryBookEntryViewRequest, String pathParam) {
        String integrationServiceName="http://localhost:8081/";
        String integrationServiceEndpoint="library/books/integration/bookUpdate";
        LibraryBookEntryIntegrationRequest libraryBookEntryIntegrationRequest = createBookEntryIntegrationRequest(libraryBookEntryViewRequest);
        String integrationServiceUrl=createIntegrationServiceUrl(integrationServiceName,integrationServiceEndpoint,pathParam);
        HttpEntity<LibraryBookEntryIntegrationRequest> entity = new HttpEntity<>(libraryBookEntryIntegrationRequest);
        return libraryViewService.libraryBookEntryUpdateIntegrationServiceCall(integrationServiceUrl, HttpMethod.PUT,entity,String.class);

    }
}
