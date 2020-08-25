package com.ohanasalut.ohanacms.repositories;

import com.ohanasalut.ohanacms.entities.OhanaUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<OhanaUser, Long> {
    Optional<OhanaUser> findByEmail(String email);
}
