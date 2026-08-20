package io.github.jesseYeh0319.ticketing.catalog;

import io.github.jesseYeh0319.ticketing.TestcontainersConfiguration;
import io.github.jesseYeh0319.ticketing.catalog.domain.Event;
import io.github.jesseYeh0319.ticketing.catalog.domain.EventStatus;
import io.github.jesseYeh0319.ticketing.catalog.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class EventRepositoryTest {

    @Autowired
    EventRepository eventRepository;

    @Test
    void saveAndFindEvent() {
        // given
        Event event = new Event("五月天 2026 演唱會", "台北大巨蛋");

        // when
        Event saved = eventRepository.save(event);
        Event found = eventRepository.findById(saved.getId()).orElseThrow();

        // then
        assertThat(found.getId()).isNotNull();
        assertThat(found.getName()).isEqualTo("五月天 2026 演唱會");
        assertThat(found.getVenue()).isEqualTo("台北大巨蛋");
        assertThat(found.getStatus()).isEqualTo(EventStatus.DRAFT);
        assertThat(found.getCreatedAt()).isNotNull();
    }
}