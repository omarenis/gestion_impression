package com.management_teachers_impression.management_teachers_impression.models.entities;

import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Subject {
    @Getter @Setter private Long id;
    @Getter @Setter @NonNull private String label;
}
