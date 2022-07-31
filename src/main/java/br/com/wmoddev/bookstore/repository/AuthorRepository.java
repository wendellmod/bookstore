package br.com.wmoddev.bookstore.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wmoddev.bookstore.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {

}
