package at.htl.control;

import at.htl.entity.Company;
import at.htl.entity.Person;
import at.htl.entity.Project;
import at.htl.entity.ProjectMember;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

@ApplicationScoped
public class InitBean {

    @Inject
    CompanyRepository companyRepository;

    @Inject
    PersonRepository personRepository;

    @Inject
    ProjectRepository projectRepository;

    @Inject
    ProjectMemberRepository projectMemberRepository;

    private void init(@Observes StartupEvent event) {

        Company company = new Company(
                "password",
                "company@mail.com",
                "wiesifilms.at",
                "Wiesi Films",
                "Wiesistreet 12");

        company = companyRepository.save(company);

        Person person = new Person(
                "password",
                "user@mail.com",
                "wiesingerjonas.com",
                "Jonas",
                "Wiesinger",
                LocalDate.of(2003, Month.JUNE,23)
        );

        Project medientechnik = new Project(
                "Imagevideo Medientechnik",
                "Ein Werbefilm über den Medientechnikzweig der HTL Leonding",
                LocalDate.of(2022,Month.JANUARY,24),
                LocalDate.of(2022,Month.FEBRUARY,7),
                company
        );

        Project medizintechnik = new Project(
                "Imagevideo Medizintechnik",
                "Ein Werbefilm über den Medizintechnikzweig der HTL Leonding",
                LocalDate.of(2022,Month.JANUARY,10),
                LocalDate.of(2022,Month.JANUARY,24),
                company
        );

        Project informatik = new Project(
                "Imagevideo Informatik",
                "Ein Werbefilm über den Informatikzweig der HTL Leonding",
                LocalDate.of(2022,Month.FEBRUARY,7),
                LocalDate.of(2022,Month.FEBRUARY,21),
                company
        );


        person = personRepository.save(person);

        medientechnik = projectRepository.save(medientechnik);
        medizintechnik = projectRepository.save(medizintechnik);
        informatik = projectRepository.save(informatik);

        projectMemberRepository.save(new ProjectMember(null,medientechnik,person));
        projectMemberRepository.save(new ProjectMember(null,medizintechnik,person));
        projectMemberRepository.save(new ProjectMember(null,informatik,person));
    }
}
