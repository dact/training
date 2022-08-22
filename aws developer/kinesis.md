
--
https://docs.aws.amazon.com/firehose/latest/dev/writing-with-sdk.html
  
Amazon Kinesis Data Firehose is a fully managed service for delivering real-time streaming data
Kinesis Data Firehose is part of the Kinesis streaming data platform

configure producers to 
send data to Kinesis Data Firehose, and it 
automatically delivers the data to the destination that you specified.
configure Kinesis Data Firehose to transform your data before delivering it. -- lambda

Putting data requires only the Kinesis Data Firehose 
- delivery stream name
- byte buffer (<=1000 KB).

https://docs.aws.amazon.com/firehose/latest/dev/what-is-this-service.html

Concepts:
- Kinesis Data Firehose delivery stream
  - The underlying entity of Kinesis Data Firehose. You use Kinesis Data Firehose by creating a Kinesis 
  - Data Firehose delivery stream and then sending data to it. For more information
- record: 
  - The data of interest that your data producer sends to a Kinesis Data Firehose delivery stream. 
  - A record can be as large as 1,000 KB.
- data producer
  - Producers send records to Kinesis Data Firehose delivery streams. For example, a web server that sends log data 
  - to a delivery stream is a data producer. You can also configure your Kinesis Data Firehose delivery stream 
  - to automatically read data from an existing Kinesis data stream, and load it into destinations. 
  - For more information, see Sending Data to an Amazon Kinesis Data Firehose Delivery Stream.
  - buffer size and buffer interval
    - Kinesis Data Firehose buffers incoming streaming data to a certain size or for a certain period of time before 
    - delivering it to destinations. Buffer Size is in MBs and Buffer Interval is in seconds.






```

PutRecordRequest putRecordRequest = new PutRecordRequest();
putRecordRequest.setDeliveryStreamName(deliveryStreamName);

String data = line + "\n";

Record record = new Record().withData(ByteBuffer.wrap(data.getBytes()));
putRecordRequest.setRecord(record);

// Put record into the DeliveryStream
firehoseClient.putRecord(putRecordRequest);

```

