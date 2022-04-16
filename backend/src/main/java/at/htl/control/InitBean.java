package at.htl.control;

import at.htl.entity.*;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import io.quarkus.runtime.StartupEvent;
import net.bytebuddy.asm.Advice;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

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

    @Inject
    VacancyRepository vacancyRepository;

    private void init(@Observes StartupEvent event) {

        LocalDate thisWeek = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        LocalDate lastWeek = thisWeek.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        LocalDate lastLastWeek = lastWeek.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        LocalDate nextWeek = thisWeek.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDate nextNextWeek = nextWeek.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        //region Accounts
        Company company = new Company(
                "password",
                "company@mail.com",
                "wiesifilms.at",
                "Wiesi Films",
                "Wiesistreet 12");

        Company company2 = new Company(
                "password",
                "doorfilms@mail.com",
                "doorfilms.at",
                "Doorfilms",
                "Doorstreet 12");

        company = companyRepository.save(company);
        company2 = companyRepository.save(company2);

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
        //endregion

        //region Projects

        Project medientechnik = new Project(
                "Imagevideo Medientechnik",
                "Ein Werbefilm über den Medientechnikzweig der HTL Leonding",
                lastWeek,
                thisWeek,
                company
        );

        Project medizintechnik = new Project(
                "Imagevideo Medizintechnik",
                "Ein Werbefilm über den Medizintechnikzweig der HTL Leonding",
                thisWeek,
                nextWeek,
                company
        );

        Project informatik = new Project(
                "Imagevideo Informatik",
                "Ein Werbefilm über den Informatikzweig der HTL Leonding",
                nextWeek,
                nextNextWeek,
                company
        );

        Project project1 = new Project(
                "Krieg der Sterne",
                "Der junge Luke Skywalker lebt auf der Farm seines Onkels auf dem Wüstenplaneten Tatooine." +
                " Eines Tages findet er in einem Roboter eine geheime Botschaft." +
                " Er macht sich auf die Suche nach dem eigentlichen Empfänger der Botschaft",
                nextWeek,
                nextNextWeek,
                company2
        );
        //endregion

        person = personRepository.save(person);
        person2 = personRepository.save(person2);
        person3 = personRepository.save(person3);
        person4 = personRepository.save(person4);
        person5 = personRepository.save(person5);

        medientechnik = projectRepository.save(medientechnik);
        medizintechnik = projectRepository.save(medizintechnik);
        informatik = projectRepository.save(informatik);
        project1 = projectRepository.save(project1);


        projectMemberRepository.save(new ProjectMember(null, medientechnik, person));
        projectMemberRepository.save(new ProjectMember(null, medizintechnik, person));
        projectMemberRepository.save(new ProjectMember(null, informatik, person));

        //region Vacancy
        Vacancy focusPuller = new Vacancy(
                "Focus Puller",
                "We are searching for a motivated and experienced Focus Puller for our Project.",
                nextWeek,
                true,
                company,
                informatik
        );

        Vacancy assistant = new Vacancy(
                "Assistant",
                "We are searching for a motivated and experienced Focus Puller for our Project.",
                nextNextWeek,
                true,
                company,
                informatik
        );

        Vacancy cinematographer = new Vacancy(
                "Cinematographer",
                "We are searching for a motivated and experienced Focus Puller for our Project.",
                nextWeek,
                true,
                company2,
                project1
        );

        Vacancy clapperOperator = new Vacancy(
                "Clapper Operator",
                "We are searching for a motivated and experienced Focus Puller for our Project.",
                nextNextWeek,
                true,
                company2,
                project1
        );
        //endregion

        focusPuller = vacancyRepository.save(focusPuller);
        assistant = vacancyRepository.save(assistant);
        cinematographer = vacancyRepository.save(cinematographer);
        clapperOperator = vacancyRepository.save(clapperOperator);

        employeeRepository.save(new Employee(null, person, company, true));
        employeeRepository.save(new Employee(null, person2, company, true));
        employeeRepository.save(new Employee(null, person3, company, false));
        employeeRepository.save(new Employee(null, person4, company, true));
        employeeRepository.save(new Employee(null, person5, company, false));

        Chat chat1 = chatRepository.save(new Chat(person, person2, "abc"));
        Chat chat2 = chatRepository.save(new Chat(company, person, "def"));
        Chat chat3 = chatRepository.save(new Chat(company, person2, "ghi"));
        Chat chat4 = chatRepository.save(new Chat(company, person3, "jkl"));

        //region Chat1
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
        //endregion

        //region Chat2
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
        //endregion

        //region Chat 3
        messageRepository.save(
                new Message(
                        company,
                        "Hey I see you have applied for our job offer! Have you got any references?",
                        LocalDateTime.of(2022, 3, 17, 13, 13),
                        chat3));

        messageRepository.save(
                new Message(
                        person2,
                        "Yes! I will email you my portfolio!",
                        LocalDateTime.of(2022, 3, 17, 14, 13),
                        chat3));

        messageRepository.save(
                new Message(
                        person2,
                        "Thank you very much! We will contact you!",
                        LocalDateTime.of(2022, 3, 17, 15, 13),
                        chat3));
        //endregion

        //region Chat 4
        messageRepository.save(
                new Message(
                        company,
                        "Dear Mr Scholl, unfortunately, we cannot offer you a position at the moment that fits your profile and meets your expectations.",
                        LocalDateTime.of(2022, 3, 2, 15, 13),
                        chat4));
        messageRepository.save(
                new Message(
                        company,
                        "However, we would like to include you in our talent pool and get back to you.",
                        LocalDateTime.of(2022, 3, 2, 15, 14),
                        chat4));
        messageRepository.save(
                new Message(
                        company,
                        "If we should create a position in the future that better suits your profile.",
                        LocalDateTime.of(2022, 3, 2, 15, 15),
                        chat4));
        messageRepository.save(
                new Message(
                        company,
                        "Please get in touch with us if you agree to this.",
                        LocalDateTime.of(2022, 3, 2, 15, 16),
                        chat4));
        messageRepository.save(
                new Message(
                        person3,
                        "Yes please do that",
                        LocalDateTime.of(2022, 3, 2, 16, 17),
                        chat4));
        //endregion

    }
}
