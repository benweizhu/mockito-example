package service;

import model.CreateJobCommand;
import model.DeleteJobCommand;
import model.Job;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.JobRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JobServiceTest {

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobService jobService;

    @Captor
    private ArgumentCaptor<Job> argumentCaptor;

    @Test
    void should_return_job_when_save_job_successfully_given_valid_create_job_command() {
        String jobName = "job name";
        Job expectedSavedJob = new Job(jobName);
        when(jobRepository.save(argumentCaptor.capture())).thenReturn(expectedSavedJob);

        Job actualSavedJob = jobService.create(new CreateJobCommand(jobName));

        assertEquals(expectedSavedJob, actualSavedJob);

        assertEquals(jobName, argumentCaptor.getValue().getName());
        assertNotNull(argumentCaptor.getValue().getId());
    }

    @Test
    void should_delete_job_successfully_when_delete_job_given_job_existed() {
        jobService.delete(new DeleteJobCommand("id"));
        verify(jobRepository).delete("id");
    }
}