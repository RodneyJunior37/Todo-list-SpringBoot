package com.rodneyjr.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.rodneyjr.todolist.entity.Todo;

@SpringBootTest
class TodoListApplicationTests {
	@Autowired
	private WebTestClient webTestClient;
	@Test
	void testCreateTodoSucess() {
		var todo = new Todo("todo1", "desc todo 1", false, 1 );
		webTestClient 
			.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("%.length()").isEqualTo(1)
			.jsonPath("%[0].nome()").isEqualTo(todo.getNome())
			.jsonPath("%[0].descricao()").isEqualTo(todo.getDescricao())
			.jsonPath("%[0].realizado()").isEqualTo(todo.isRealizado())
			.jsonPath("%[0].prioridade()").isEqualTo(todo.getPrioridade());
	}


		@Test
	void testCreateTodoFailure() {
	}

}
