package com.samsoelocalelection.SamsoeLocalElection.Repo;

import com.samsoelocalelection.SamsoeLocalElection.Models.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatesRepo extends JpaRepository<Candidates, Long> {


}
