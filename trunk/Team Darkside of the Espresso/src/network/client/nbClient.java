package network.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import network.Message;
import network.MessageKey;
import network.Network;

public class nbClient
{
	public nbClient()
	{
		try
		{
			// Create client SocketChannel
			SocketChannel client = SocketChannel.open();
	
			// nonblocking I/O
			client.configureBlocking(false);
	
			// Connection to host port 8000
			client.connect(new java.net.InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8000));
			// Create selector
			Selector selector = Selector.open();
	
			// Record to selector (OP_CONNECT type)
			SelectionKey clientKey = client.register(selector, SelectionKey.OP_CONNECT);
	
			// Waiting for the connection
			while (selector.select(500)> 0)
			{
				// Get keys
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> i = keys.iterator();
				
				// For each key...
				while (i.hasNext())
				{
					SelectionKey key = (SelectionKey)i.next();
					
					// Remove the current key
					i.remove();
					
					// Get the socket channel held by the key
					SocketChannel channel = (SocketChannel)key.channel();
					
					// Attempt a connection
					if (key.isConnectable())
					{
						// Connection OK
						System.out.println("Server Found");
						
						// Close pending connections
						if (channel.isConnectionPending())
						{
							channel.finishConnect();
						}
						
						// Write continuously on the buffer
						ByteBuffer buffer = null;
						
						//for (;;)
						//{
							Message msg = new Message(MessageKey.ECHO);
							byte arr[] = Network.toBytes(msg);
							byte size[] = new byte[4];
							
							for (int j = 0; j < 4; j++)
							{
					            int offset = (size.length - 1 - j) * 8;
					            size[j] = (byte) ((arr.length >>> offset) & 0xFF);
					        }
							
							for (int j = 0; j < 4; j++)
							{
								System.out.println(size[j]);
							}
							System.out.println(arr.length);
							
							buffer = ByteBuffer.wrap(size);
							
							channel.write(buffer);
							buffer.clear();
						//}
					}
				}
			}
		}
		catch (IOException e)
		{
			// TODO
			System.out.println(e);
		}
	}
}
