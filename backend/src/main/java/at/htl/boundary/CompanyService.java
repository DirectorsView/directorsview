package at.htl.boundary;

import at.htl.control.CompanyRepository;
import at.htl.control.EmployeeRepository;
import at.htl.control.PersonRepository;
import at.htl.entity.Company;
import at.htl.entity.Employee;
import at.htl.entity.Person;
import at.htl.entity.Project;
import org.hibernate.exception.ConstraintViolationException;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/company")
@Produces(MediaType.APPLICATION_JSON)
public class CompanyService {
    @Inject
    CompanyRepository companyRepository;

    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    PersonRepository personRepository;

    @GET
    public List<Company> getAll() {
        return companyRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Company company) {
        try {
            return Response
                    .ok(companyRepository.save(company))
                    .build();
        } catch (PersistenceException e) {
            return Response
                    .status(400)
                    .entity("Email already used")
                    .build();
        }
    }

    @GET
    @Path("{id}")
    public Company getOne(@PathParam("id") Long id) {
        return companyRepository.findById(id);
    }

    @GET
    @Path("{id}/employees")
    public List<Person> getEmployees(@PathParam("id") Long id) {
        return employeeRepository.find("company.id", id).stream()
                .map(Employee::getPerson)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}/projects")
    public List<Project> getProjects(@PathParam("id") Long id) {
        return companyRepository.findProjects(id);
    }

    @POST
    @Path("{id}/employees")
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addEmployee(@PathParam("id") Long companyId,
                              @QueryParam("personId") Long personId,
                              @QueryParam("isAdmin") Boolean isAdmin) {

        Company company = companyRepository.findById(companyId);
        Person person = personRepository.findById(personId);
        employeeRepository.save(new Employee(null, person, company, isAdmin));

        return person;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Company put(@PathParam("id") long id, Company company) {
        Company originalCompany = companyRepository.findById(id);

        if (originalCompany != null) {
            originalCompany.setPassword(company.getPassword());
            originalCompany.setEmail(company.getEmail());
            originalCompany.setWebsite(company.getWebsite());
            originalCompany.setName(company.getName());
            originalCompany.setAddress(company.getAddress());
        }

        return originalCompany;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Company delete(@PathParam("id") long id) {
        Company company = companyRepository.findById(id);
        company.delete("id = " + id);
        return company;
    }
}