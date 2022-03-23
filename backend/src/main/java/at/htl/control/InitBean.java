package at.htl.control;

import at.htl.entity.*;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@ApplicationScoped
@Transactional
public class InitBean {

    @Inject
    CompanyRepository companyRepository;

    @Inject
    PersonRepository personRepository;

    @Inject
    ProjectRepository projectRepository;

    @Inject
    ProjectMemberRepository projectMemberRepository;

    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    ChatRepository chatRepository;

    @Inject
    MessageRepository messageRepository;

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
                LocalDate.of(2003, Month.JUNE, 23)
        );

        Person person2 = new Person(
                "password",
                "dorfi@mail.com",
                "dorfingerjonas.at",
                "Jonas",
                "Dorfinger",
                LocalDate.of(2003, Month.JUNE, 3)
        );

        Person person3 = new Person(
                "password",
                "basti@mail.com",
                "schollsebastian.com",
                "Sebastian",
                "Scholl",
                LocalDate.of(2002, Month.SEPTEMBER, 1)
        );

        Person person4 = new Person(
                "password",
                "carli@mail.com",
                "schollsebastian.com",
                "Carlos",
                "Dumfarth",
                LocalDate.of(2002, Month.NOVEMBER, 2)
        );

        Person person5 = new Person(
                "password",
                "susi@mail.com",
                "susi.lustig.at",
                "Susi",
                "Lustig",
                LocalDate.of(2001, Month.JUNE, 24)
        );

        Project medientechnik = new Project(
                "Imagevideo Medientechnik",
                "Ein Werbefilm über den Medientechnikzweig der HTL Leonding",
                LocalDate.of(2022, Month.MARCH, 14),
                LocalDate.of(2022, Month.MARCH, 21),
                company
        );

        Project medizintechnik = new Project(
                "Imagevideo Medizintechnik",
                "Ein Werbefilm über den Medizintechnikzweig der HTL Leonding",
                LocalDate.of(2022, Month.MARCH, 21),
                LocalDate.of(2022, Month.MARCH, 28),
                company
        );

        Project informatik = new Project(
                "Imagevideo Informatik",
                "Ein Werbefilm über den Informatikzweig der HTL Leonding",
                LocalDate.of(2022, Month.MARCH, 7),
                LocalDate.of(2022, Month.MARCH, 14),
                company
        );

        person = personRepository.save(person);
        person2 = personRepository.save(person2);
        person3 = personRepository.save(person3);
        person4 = personRepository.save(person4);
        person5 = personRepository.save(person5);

        medientechnik = projectRepository.save(medientechnik);
        medizintechnik = projectRepository.save(medizintechnik);
        informatik = projectRepository.save(informatik);

        projectMemberRepository.save(new ProjectMember(null, medientechnik, person));
        projectMemberRepository.save(new ProjectMember(null, medizintechnik, person));
        projectMemberRepository.save(new ProjectMember(null, informatik, person));

        employeeRepository.save(new Employee(null, person, company, true));
        employeeRepository.save(new Employee(null, person2, company, true));
        employeeRepository.save(new Employee(null, person3, company, false));
        employeeRepository.save(new Employee(null, person4, company, true));
        employeeRepository.save(new Employee(null, person5, company, false));

        Chat chat1 = chatRepository.save(new Chat(person, person2, "abc"));
        Chat chat2 = chatRepository.save(new Chat(company, person, "def"));

        messageRepository.save(
                new Message(
                        person,
                        "Hey! What's up?",
                        LocalDateTime.of(2022, 3, 23, 21, 4),
                        chat1));

        messageRepository.save(
                new Message(
                        person2,
                        "I'm good! How are you?",
                        LocalDateTime.of(2022, 3, 23, 21, 5),
                        chat1));

        messageRepository.save(
                new Message(
                        company,
                        "Hey I see you have applied for our job offer! Have you got any references?",
                        LocalDateTime.of(2022, 3, 22, 18, 5),
                        chat2));

        messageRepository.save(
                new Message(
                        person,
                        "Yeah just visit my website! You can see my portfolio there!",
                        LocalDateTime.of(2022, 3, 22, 19, 37),
                        chat2));

        messageRepository.save(
                new Message(
                        company,
                        "Wow that looks great! Can you call us tomorrow at 3pm so that we can talk about the details of the job?",
                        LocalDateTime.of(2022, 3, 22, 19, 42),
                        chat2));
    }
}
