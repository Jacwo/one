/******************************************************************************
 * Copyright (C) 2016 ShangHai FlashHold Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ�Ϻ�������ܿƼ��������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ�����
 * ����ʹ�á����ơ��޸Ļ򷢲������.
 *****************************************************************************/

package cn.yyl.interview.lock;

/**
 * ������
 * 
 * @author kim.cheng
 * 
 * @history Aug 17, 2016
 * 
 */
public interface Lock {
	/**
	 * �����������������
	 * 
	 * @return
	 */
	boolean acquire();

	/**
	 * ����� 
	 * @param timeout long ��ʱʱ�䣬��λ����
	 * 
	 * @return
	 */
	boolean acquire(long timeout);

	/**
	 * �ͷ���
	 * 
	 * @return
	 */
	void release();
}
