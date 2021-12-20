package com.samsoelocalelection.SamsoeLocalElection.Controller;

import com.samsoelocalelection.SamsoeLocalElection.Models.Candidates;
import com.samsoelocalelection.SamsoeLocalElection.Repo.CandidatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private CandidatesRepo candidatesRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome to the Samsoe Election Details";
    }
    @GetMapping(value = "/candidates/")
    public List<Candidates> getCandidates() {
        return candidatesRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveCandidates(@RequestBody Candidates candidates) {
        candidatesRepo.save(candidates);
        return "Saved...";
    }
    @PutMapping(value = "update/{id}")
    public String updateCandidate(@PathVariable long id, @RequestBody Candidates candidates) {
        Candidates updatedCandidate = candidatesRepo.findById(id).get();
        updatedCandidate.setFirstName(candidates.getFirstName());
        updatedCandidate.setLastName(candidates.getLastName());
        updatedCandidate.setParty(candidates.getParty());
        candidatesRepo.save(updatedCandidate);
        return "Updated....";
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteCandidate(@PathVariable long id) {
        Candidates deleteCandidate = candidatesRepo.findById(id).get();
        candidatesRepo.delete(deleteCandidate);
        return "Delete user with the id: "+id;
    }
}
