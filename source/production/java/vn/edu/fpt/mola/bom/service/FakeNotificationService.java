package vn.edu.fpt.mola.bom.service;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class FakeNotificationService implements NotificationService
{
    private static final Logger log = LogManager.getLogger();

    @Override
    public void sendNotification(String subject, String message,
            Collection<String> recipients)
    {
        log.info("Started notifying recipients {}.", recipients);
        try {
            Thread.sleep(5_000L);
        } catch (InterruptedException e) {
        }
        log.info("Finished notifying recipients.");
    }

}
