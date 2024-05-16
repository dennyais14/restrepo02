package co.develhope.repo02.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "programmingLanguages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String inventor;

    @Column
    private LocalDate firstAppearance;
}
