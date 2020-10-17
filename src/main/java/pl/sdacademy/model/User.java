package pl.sdacademy.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL)
    private Set<Contact> contacts;

    @OneToOne(cascade = CascadeType.ALL)
    private Lockdown lockdown;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", contacts=" + contacts +
                ", lockdown=" + lockdown +
                '}';
    }
}
