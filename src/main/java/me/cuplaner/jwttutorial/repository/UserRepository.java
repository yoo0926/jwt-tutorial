package me.cuplaner.jwttutorial.repository;

import me.cuplaner.jwttutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository를 extends 하면서 findAll, save등의 메소드를 기본적으로 사용할 수 있게 됨
public interface UserRepository extends JpaRepository<User, Long> {
    //어노테이션은 해당 쿼리를 수행할 때 Lazy조회가 아닌 Eager조회로 authorities정보를 같이 가져온다.
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}