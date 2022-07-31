package br.com.wmoddev.bookstore.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@MappedSuperclass
@Getter @AllArgsConstructor @ToString
public class BaseEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    
    @Column(name = "creation_date_time", nullable = false)
    @CreationTimestamp
    private LocalDateTime creationDateTime;
    
    @Column(name = "modification_date_time", nullable = false)
    @UpdateTimestamp
    private LocalDateTime modificationDateTime;
    
    @Deprecated
	public BaseEntity() {}

}
