package org.test;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public class PersonHandler3 {

	public Mono<ServerResponse> getPerson(ServerRequest request) {
		return ServerResponse.notFound().build();
	}

	public Mono<ServerResponse> createPerson(ServerRequest request) {
		return ServerResponse.notFound().build();
	}

	public Mono<ServerResponse> listPeople(ServerRequest request) {
		return ServerResponse.notFound().build();
	}

	public Mono<ServerResponse> deletePerson(ServerRequest request) {
		return ServerResponse.notFound().build();
	}

}
