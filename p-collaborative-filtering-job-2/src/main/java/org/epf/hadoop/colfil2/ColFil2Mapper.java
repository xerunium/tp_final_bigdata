package org.epf.hadoop.colfil2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ColFil2Mapper extends Mapper<LongWritable, Text, UserPair, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] line = value.toString().split("\t");
        if (line.length < 2) {
            return;
        }

        String user = line[0];
        String[] friends = line[1].split(",");
        Set<String> friendsSet = new HashSet<>(Arrays.asList(friends));
        for (String friend : friendsSet) {
            for (String friend2 : friendsSet) {
                if(!friend.equals(friend2)) {
                    context.write(new UserPair(friend, friend2), new Text(user));
                }
            }
        }
    }
}