package cn.itcast.redis;

import redis.clients.jedis.Jedis;

/**
 * 使用官方提供的集群方式
 * 连接池同理，只是把 ShardedJedis 换成 JedisCluster
 */
public class JedisDemo {

    public static void main(String[] args) {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		// 只需要写一个节点就可
		nodes.add(new HostAndPort("192.168.56.101", 6379));
		JedisCluster jedisCluster = new JedisCluster(nodes);

		// 不需要手动关闭连接，会自动关闭
		jedisCluster.set("k", "v");
    }

}
