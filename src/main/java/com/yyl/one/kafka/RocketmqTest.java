package com.yyl.one.kafka;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/10/14 14:44
 */
public class RocketmqTest implements TransactionListener {
	@Override
	public LocalTransactionState executeLocalTransaction(Message message, Object o) {
		return null;
	}

	@Override
	public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
		return null;
	}
}
