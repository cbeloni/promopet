package br.com.promopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.promopet.entity.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Long>, PagingAndSortingRepository<Promocao, Long>{

}
