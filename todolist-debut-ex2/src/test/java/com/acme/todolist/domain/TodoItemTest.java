package com.acme.todolist.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;

class TodoItemTest {

    @Test
    void testLateTag() {
        Instant dateAncienne = Instant.now().minus(2, ChronoUnit.DAYS);
        TodoItem item = new TodoItem("1", dateAncienne, "Faire mon TP");
        assertEquals("[LATE!] Faire mon TP", item.finalContent());
    }
}