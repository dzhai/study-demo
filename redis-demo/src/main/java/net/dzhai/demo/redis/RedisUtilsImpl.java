package net.dzhai.demo.redis;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisUtilsImpl {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private int redis_NODE_NUM=100;
	
	/**
	 * redis 默认集群
	 */
	private ShardedJedisPool shardedJedisPool;

	/**
	 * shardedJedisPoolMap: redis集群
	 */
	private Map<Integer, ShardedJedisPool> shardedJedisPoolMap;

	/**
	 * 获取Jedis连接；预留功能，可以根据key对redis进行分布访问
	 * 
	 */
	private ShardedJedis getShardedJedis(String key) {

		return shardedJedisPool.getResource();
	}

	private ShardedJedis getShardedJedis() {

		return shardedJedisPool.getResource();
	}

	public void setShardedJedisPoolMap(Map<Integer, ShardedJedisPool> shardedJedisPoolMap) {
		this.shardedJedisPoolMap = shardedJedisPoolMap;
	}

	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}

	/**
	 * 释放资源
	 * 
	 * @param key
	 * @param redis
	 */
	private void returnResource(String key, ShardedJedis shardedJedis) {
		shardedJedisPool.returnResource(shardedJedis);
		/*
		 * ShardedJedisPool pool=null; try{ int id = Integer.parseInt(key); int
		 * redisKey = id/Common.REDIS_DATA_NUM+1; pool =
		 * shardedJedisPoolMap.get(redisKey); }catch(Exception e){
		 * shardedJedisPool.returnResource(shardedJedis);
		 * //对于存储id以外的key，有shardedJedisPool提供 } if(pool!=null){
		 * pool.returnResource(shardedJedis); }else{
		 * shardedJedisPool.returnResource(shardedJedis);
		 * //如果某一台存放企业ID的redis服务宕机，有shardedJedisPool提供临时提供服务 }
		 */
	}

	/**
	 * 释放资源
	 * 
	 * @param redis
	 */
	private void returnResource(ShardedJedis shardedJedis) {
		shardedJedisPool.returnResource(shardedJedis);
	}

	/**
	 * 释放不可用的资源
	 * 
	 * @param key
	 * @param redis
	 * 
	 */
	private void returnBrokenResource(ShardedJedis shardedJedis) {
		shardedJedisPool.returnBrokenResource(shardedJedis);
	}

}
