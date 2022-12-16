package br.com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.challenge.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
