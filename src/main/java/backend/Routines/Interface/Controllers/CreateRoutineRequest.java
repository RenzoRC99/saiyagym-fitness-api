package backend.Routines.Interface.Controllers;

import lombok.Data;

@Data
public class CreateRoutineRequest {

    private String userId;

    private String name;

    private boolean status;

    private String description;
}
