package org.hartford.eventguard.repo;

import org.hartford.eventguard.entity.PolicySubscription;
import org.hartford.eventguard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicySubscriptionRepository extends JpaRepository<PolicySubscription, Long> {

    List<PolicySubscription> findByEvent_User(User user);
}
