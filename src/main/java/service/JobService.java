package service;

import model.CreateJobCommand;
import model.DeleteJobCommand;
import model.Job;
import repository.JobRepository;

import java.util.UUID;

public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job create(CreateJobCommand createJobCommand) {
        Job job = new Job(createJobCommand.getName());
        return jobRepository.save(job);
    }

    public void delete(DeleteJobCommand deleteJobCommand) {
        jobRepository.delete(deleteJobCommand.getId());
    }
}
