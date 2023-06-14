package com.view.library.librarysystem.libraryviewsystem.api.integration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
@Setter
@Getter
@NoArgsConstructor
public class LibraryBookEntryIntegrationRequest {

    @NonNull
    private String personName;
    @NonNull
    private String personEmail;
    @NonNull
    private String bookNameAndAuthorName;
    @NonNull
    private String bookStatus;
    @NonNull
    private LocalDate dateUpdated;
}
