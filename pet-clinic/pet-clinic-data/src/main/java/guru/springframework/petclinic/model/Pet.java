package guru.springframework.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet extends NamedEntity {

    @Builder
    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        super(id, name);
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
        this.visits = visits;
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
