package br.com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.challenge.model.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer>{
	
}
