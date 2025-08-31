package s3config;

import java.io.File;
import org.apache.commons.configuration.PropertiesConfiguration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

public class s3configuration {
	private String accesskey;
	private String secretkey;
	private String region;
	private String bucket;
	private S3Client s3Client;
	
public s3configuration() {
	loadProperties();
	initS3Client();
}
private void loadProperties() {
	try {
		PropertiesConfiguration config = new PropertiesConfiguration();
		config.load(new File("application.properties"));
		
		accesskey=config.getString("aws.accessKey");
		secretkey=config.getString("aws.secretKey");
		region=config.getString("aws.region");
		bucket=config.getString("aws.s3.bucket");

	} catch (Exception e) {
		throw new RuntimeException("error in loading"+e.getMessage());
		// TODO: handle exception
	}
}
private void initS3Client() {
	s3Client = S3Client.builder().region(Region.of(region)).credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accesskey, secretkey))).build();

}
public S3Client getS3Client() {
	return s3Client;
}
public String getbucketname() {
	return bucket;	
}

}