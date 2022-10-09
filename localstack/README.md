



awslocal s3 mb s3://kinesis-activity-backup-local

awslocal kinesis create-stream --stream-name kinesis-es-local-stream --shard-count 2

awslocal kinesis put-record --stream-name kinesis_es-local_stream --data '{ "target": "barry" }' --partition-key partition
