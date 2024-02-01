package br.com.course.application.protocols;

public interface AuthenticateUserUseCase {
    Boolean auth(String username, String password);
}
