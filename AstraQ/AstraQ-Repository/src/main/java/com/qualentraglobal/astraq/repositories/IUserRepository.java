package com.qualentraglobal.astraq.repositories;

import com.qualentraglobal.astraq.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long>{

    @Query("SELECT u FROM Users u WHERE u.mobilenumber = :#{#users.mobilenumber} AND u.password = :#{#users.password} AND u.isActive = true")
    Users login(@Param("users") Users users);

}
