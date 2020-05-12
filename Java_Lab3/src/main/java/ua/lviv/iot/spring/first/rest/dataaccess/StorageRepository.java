package ua.lviv.iot.spring.first.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.spring.first.rest.model.Thermos;

@Repository
public interface StorageRepository extends JpaRepository<Thermos, Integer> {

}