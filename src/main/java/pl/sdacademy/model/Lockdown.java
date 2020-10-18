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
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    LocalDate start;
    LocalDate end;
}
