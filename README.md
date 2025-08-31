This is simple java application which has only purpose to upload and download the file in AWS S3 bucket.

There are few prerequisites to run this application. And those are: 
- Create an IAM user through AWS console and provide AmazonS3FullAccess.
- Generate a secret key and an access key for that account. (Create access key > Use Case:local code > Create access key).
- Create a AWS S3 bucket in any of your prefered region, and copy the bucket name.
- In this project there is a properties file named as application.properties. 
- Store the secret key, access key, region_id, and bucket name in the form of key value pair.

When application runs, in console when it ask for file path then enter the complete file path with extention and when it ask for object then enter the name which you want to display in the bucket.
