package com.management_teachers_impression.management_teachers_impression.models.entities;



import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    @Getter @Setter private Long id;
    @Getter @Setter @NonNull private String firstname;
    @Getter @Setter @NonNull private String lastname;
    @Getter @Setter @NonNull private String email;
    @Getter @Setter @NonNull private String password;
    @Getter @Setter @NonNull private String role;
    @Getter @Setter @NonNull private Boolean isActivated;
}
