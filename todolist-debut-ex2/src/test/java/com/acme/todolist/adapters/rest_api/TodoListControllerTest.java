package com.acme.todolist.adapters.rest_api;

import com.acme.todolist.TodoListController;
import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.port.in.GetTodoItems;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoListController.class)
class TodoListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddTodoItem addTodoItem;

    @MockBean
    private GetTodoItems getTodoItems;

    @Test
    void testPostStatus201() throws Exception {
        String json = "{\"id\":\"1\",\"content\":\"Test\"}";

        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }
}