package com.all4tic.suiviscolaire.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.all4tic.suiviscolaire.entities.Message;

public interface MessageDao extends CrudRepository<Message, Integer> {
		List<Message>findAllBySenderOrReceiverOrderByDatemessageDesc(int sender, int receiver);
}
