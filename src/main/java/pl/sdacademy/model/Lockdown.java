package pl.sdacademy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Lockdown {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate start;
    LocalDate end;
    @OneToOne
    private User user;

    @Override
    public String toString() {
        return "Lockdown{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
