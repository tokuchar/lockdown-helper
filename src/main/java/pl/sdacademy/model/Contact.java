package pl.sdacademy.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;

    @Enumerated(EnumType.ORDINAL)
    private ContactType contactType;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", contactType=" + contactType +
                '}';
    }
}
