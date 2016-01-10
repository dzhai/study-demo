package net.dzhai.demo.curator.crud;

import net.dzhai.demo.curator.ZKUtils;
import org.apache.curator.framework.CuratorFramework;

/**
 * Curator framework's client test.
 *  Output: 
 *  $ create /zktest hello 
 *  $ ls /[zktest, zookeeper] 
 *  $ get /zktest hello 
 *  $ set /zktest world 
 *  $ get /zktest world 
 *  $ delete /zktest 
 *  $ ls / [zookeeper]
 */
public class CuratorClientTest {

	private static final String ZK_PATH = "/zktest";

	public static void main(String[] args) throws Exception {
		// 1.Connect to zk
		CuratorFramework client =ZKUtils.getCuratorFramework();
		client.start();
		System.out.println("zk client start successfully!");

		// 2.Client API test
		// 2.1 Create node
		String data1 = "hello";
		print("create", ZK_PATH, data1);
		client.create().creatingParentsIfNeeded().forPath(ZK_PATH, data1.getBytes());

		// 2.2 Get node and data
		print("ls", "/");
		print(client.getChildren().forPath("/"));
		print("get", ZK_PATH);
		print(client.getData().forPath(ZK_PATH));

		// 2.3 Modify data
		String data2 = "world";
		print("set", ZK_PATH, data2);
		client.setData().forPath(ZK_PATH, data2.getBytes());
		print("get", ZK_PATH);
		print(client.getData().forPath(ZK_PATH));

		// 2.4 Remove node
		print("delete", ZK_PATH);
		client.delete().forPath(ZK_PATH);
		print("ls", "/");
		print(client.getChildren().forPath("/"));
	}

	private static void print(String... cmds) {
		StringBuilder text = new StringBuilder("$ ");
		for (String cmd : cmds) {
			text.append(cmd).append(" ");
		}
		System.out.println(text.toString());
	}

	private static void print(Object result) {
		System.out.println(result instanceof byte[] ? new String((byte[]) result) : result);
	}

}