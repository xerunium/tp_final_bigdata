package org.epf.hadoop.colfil3;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class RecommendationMapper extends Mapper<Object, Text, Text, Text> {
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString().trim();
        if (line.isEmpty()) {
            return;
        }

        String[] parts = line.split("\\s+");
        if (parts.length != 2) {
            return;
        }

        String[] users = parts[0].split(",");
        if (users.length != 2) {
            return;
        }

        String user1 = users[0];
        String user2 = users[1];
        String commonConnections = parts[1];

        context.write(new Text(user1), new Text(user2 + ":" + commonConnections));
        context.write(new Text(user2), new Text(user1 + ":" + commonConnections));
    }

}