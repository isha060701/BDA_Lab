import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class SSMapper extends MapReduceBase implements
Mapper<LongWritable,Text, Text, IntWritable> {

public void map(LongWritable key, Text value, OutputCollector<Text,
IntWritable> output, Reporter rep) throws IOException
	{
	
	String line = value.toString();	
	
	for (String num : line.split(" "))
		{
		int n = Integer.parseInt(num);
		int square = n * n;
		output.collect(new Text(num), new IntWritable(square));
		
		}
	}
}