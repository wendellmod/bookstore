package br.com.wmoddev.bookstore.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wmoddev.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

}
