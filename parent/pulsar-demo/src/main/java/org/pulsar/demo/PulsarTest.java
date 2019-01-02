package org.pulsar.demo;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.ConsumerStats;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Reader;

public class PulsarTest {
  static String remoteClusterUrl = "pulsar://47.110.54.31:6650";
  static PulsarClient client =null;
  static {
	  try {
		client = PulsarClient.builder().serviceUrl(remoteClusterUrl).build();
	} catch (PulsarClientException e) {
		
		e.printStackTrace();
	}
  }
  public static void main(String[] args) throws PulsarClientException{
	  new Thread(new Runnable(){
		 
		  public void run(){
			  try {
				 
				 customer();
				
			} catch (PulsarClientException e) {
				e.printStackTrace();
			}
		  }
	  }).start();
//	  new Thread(new Runnable(){
//			 
//		  public void run(){
//			  try {
//				  reader();
//			} catch (PulsarClientException e) {
//				e.printStackTrace();
//			} 
//		  }
//	  }).start();
	/*  new Thread(new Runnable(){
			 
		  public void run(){
			  try {
				 produce();
			} catch (PulsarClientException e) {
				e.printStackTrace();
			}
		  }
	  }).start();*/
  }
  
  public static void produce() throws PulsarClientException{
	  Producer<byte[]> producer = client.newProducer().topic("my-pulsarTopic").create();
	  for(int i=0;i<10;i++){
		  try {
		      MessageId msgId= producer.send("{\"hello\":\"world\"}".getBytes());
		      System.out.println("producer 的消息ID："+msgId.toString());
		      Thread.sleep(2000);
		  }catch(InterruptedException e1){
				
			}
	 }
      producer.close();
  }
  
  public static void customer() throws PulsarClientException{
	 Consumer<byte[]> consumer = client.newConsumer().topic("my-pulsarTopic").subscriptionName("test").subscribe();
	 //consumer.seek(MessageId.earliest);
	 consumer.seek(MessageId.latest);
	 ConsumerStats cs = consumer.getStats();
	 
    while(true){
    	try{
		 Message<byte[]> msg = consumer.receive();
		 MessageId msgId = msg.getMessageId();
		 consumer.acknowledge(msgId);
		 System.out.println("coustomer 消费端获取到的MessageId:"+msgId.toString());
		 System.out.println("coustomer 消费的数据："+String.valueOf(msg.getValue()));
		 Thread.sleep(1000);
    	}catch(InterruptedException e){
    		
    	}
	 }
  }
  public static void reader() throws PulsarClientException{
	  Reader<byte[]> reader = client.newReader()
			  .topic("my-pulsarTopic").startMessageId(MessageId.earliest).create();
	  while(true){
		  Message<byte[]> message = reader.readNext();
		  System.out.println("reader message ID :"+ message.getMessageId().toString());
		  System.out.println("reader 消费的数据："+String.valueOf(message.getValue()));
	  }
  }
}
