package com.management_teachers_impression.management_teachers_impression.models.entities;

import lombok.*;


import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class PrintAction {
    @Getter @Setter private Long id;
    @Getter @Setter private Long teacherId;
    @Getter @Setter private Long subjectId;
    @Getter @Setter private Subject subject;
    @Getter @Setter private User teacher;
    @Getter @Setter @NonNull private Date datAskForPrint = new Date();
    @Getter @Setter @NonNull private Boolean isValidated = false;
    @Getter @Setter @NonNull private int numberCopies;
    @Getter @Setter @NonNull private String fileUrl;
    @Getter @Setter @NonNull private String filePath;
}
