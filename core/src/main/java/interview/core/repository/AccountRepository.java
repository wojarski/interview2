package interview.core.repository;

import interview.core.model.Account;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

	@Query("select a from Account a where number = ?1")
	Account findByAccount(@Param("number") Long number);

}
