package com.omarcosallan.magalums.config;

import com.omarcosallan.magalums.entity.Channel;
import com.omarcosallan.magalums.entity.Status;
import com.omarcosallan.magalums.repository.ChannelRepository;
import com.omarcosallan.magalums.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final StatusRepository statusRepository;
    private final ChannelRepository channelRepository;

    public DataLoader(StatusRepository statusRepository, ChannelRepository channelRepository) {
        this.statusRepository = statusRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(Status.Values.values())
                .map(Status.Values::toStatus)
                .forEach(statusRepository::save);
    }
}
