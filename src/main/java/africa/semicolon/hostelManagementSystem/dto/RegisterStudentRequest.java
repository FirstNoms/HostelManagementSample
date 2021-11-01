package africa.semicolon.hostelManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterStudentRequest {
    private String firstName;
    private String lastName;
    private String matricNumber;
    private String userName;
    private String password;

}
