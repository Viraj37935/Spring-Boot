package com.YouTube.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.YouTube.Entity.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {

}
