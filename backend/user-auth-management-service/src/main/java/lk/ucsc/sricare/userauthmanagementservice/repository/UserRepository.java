package lk.ucsc.sricare.userauthmanagementservice.repository;

import lk.ucsc.sricare.userauthmanagementservice.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByNic(String nic);
    boolean existsByEmail(String email);

    User findByEmail(String email);
}
