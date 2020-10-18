package pl.sdacademy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.model.Contact;
import pl.sdacademy.model.ContactType;
import pl.sdacademy.model.Lockdown;
import pl.sdacademy.model.User;
import pl.sdacademy.repository.UserRepo;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

@Slf4j
@SpringBootApplication
public class LockdownHelperApp {
    @Autowired
    private UserRepo userRepo;

    public static void main(String... args) {
        SpringApplication.run(LockdownHelperApp.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void fillDatabase() {
        User initialUser = User.builder()
                .name("Jan")
                .surname("Kowalski")
                .contacts(Set.of(Contact.builder()
                        .contactType(ContactType.EMAIL)
                        .value("j.kowalski@gmail.com")
                        .build()))
                .lockdown(Lockdown.builder()
                                .start(LocalDate.now())
                                .end(LocalDate.of(2020, Month.OCTOBER, 18))
                                .build()).build();
        userRepo.save(initialUser);
        log.info(initialUser.toString());
        log.info(userRepo.findById(1L).get().toString());
    }

}
