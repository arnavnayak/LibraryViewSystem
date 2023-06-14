package com.view.library.librarysystem.libraryviewsystem.api.view;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@NoArgsConstructor
@Slf4j
public class LibraryBookEntryViewRequest {
    //person detail
    @NonNull
    private String firstName;

    private String lastName;
    @NonNull
    private String email;

    //book details
    @NonNull
    private String bookName;
    @Nonnull
    private String authorName;
}
