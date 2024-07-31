package io.munkush.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> notifications;
    private String firstname;
    private String lastname;
    private String email;

}
