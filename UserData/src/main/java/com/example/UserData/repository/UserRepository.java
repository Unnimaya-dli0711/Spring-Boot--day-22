package com.example.UserData.repository;

import com.example.UserData.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
        @Modifying
        @Transactional
        @Query("UPDATE User u SET u.email=?2 WHERE u.id=?1")
        void updateUserEmailById(long id,String newEmail);

        @Query("SELECT u FROM User u WHERE u.email LIKE %:domain")
        List<User> findByEmailDomain(@Param("domain") String domain);
}
