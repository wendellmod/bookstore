package br.com.wmoddev.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wmoddev.bookstore.entity.AuthorBook;
import br.com.wmoddev.bookstore.entity.AuthorBookKey;

@Repository
public interface AuthorBookRepository extends JpaRepository<AuthorBook, AuthorBookKey> {

}
