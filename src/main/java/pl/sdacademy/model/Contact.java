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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;

    @Enumerated(EnumType.ORDINAL)
    private ContactType contactType;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User user;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", contactType=" + contactType +
                ", user=" + user +
                '}';
    }
}
