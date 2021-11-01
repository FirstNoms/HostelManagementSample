package africa.semicolon.hostelManagementSystem.data.Models;

import lombok.*;

/**>> @Data is an annotation that helps in abstracting the getter and setter method, which automatically generates a getter and setter for any field that is declared in the class later and enables you to get & set any field(instance variable).
  >> Lombok is a maven artefact that helps in the above when building a project.
  >>go to your pom.xml, click on the commented link to go copy the things in the lombok.
 >> @Data creates a getter&setter for all private variables
 >> @Getter / @Setter -- is used on top of each private variable you want, to have a getter and setter.
 >> @AllArgsConstructor creates a constructor for the class
 >> @RequiredArgsConstructor creates a constructor that requires some arguments to the class constructor, so youd used the @NonNull to indicate which field should have an argument.
 >>
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String matricNumber;
    private String userName;
    private String password;
    private Bedspace bedspace;

}