package com.example.resourcesrelationnelles;


/*import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;*/

/*@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor*/

public class RoleDto {
    Long id;
    String name;

    public RoleDto(){}

    public RoleDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
