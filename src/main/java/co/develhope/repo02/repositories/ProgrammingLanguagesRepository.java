package co.develhope.repo02.repositories;

import co.develhope.repo02.entities.ProgrammingLanguages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "repo-prog-languages",
        collectionResourceDescription = @Description("this is the repository for programming languages"))
public interface ProgrammingLanguagesRepository extends JpaRepository <ProgrammingLanguages, Long>{
}
