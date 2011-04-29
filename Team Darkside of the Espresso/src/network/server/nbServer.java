package network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class nbServer
{
	public nbServer()
	{
		try
		{
			// Create the server socket channel
			ServerSocketChannel server = ServerSocketChannel.open();
			// nonblocking I/O
			server.configureBlocking(false);
			// host-port 8000
			server.socket().bind(new java.net.InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8000));
			System.out.println("Server started on port 8000");
			// Create the selector
			Selector selector = Selector.open();
			// Recording server to selector (type OP_ACCEPT)
			server.register(selector,SelectionKey.OP_ACCEPT);
			
			// Infinite server loop
			for(;;)
			{
				// Waiting for events
				selector.select();

				// Get keys
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> i = keys.iterator();
				
				// For each keys...
				while (i.hasNext())
				{
					SelectionKey key = (SelectionKey) i.next();
					
					// Remove the current key
					i.remove();
					
					// if isAccetable = true
					// then a client required a connection
					if (key.isAcceptable())
					{
						// get client socket channel
						SocketChannel client = server.accept();
						
						// Non Blocking I/O
						client.configureBlocking(false);
						
						// recording to the selector (reading
						client.register(selector, SelectionKey.OP_READ);
						
						continue;
					}
					
					// if isReadable = true
					// then the server is ready to read
					if (key.isReadable())
					{
						SocketChannel client = (SocketChannel) key.channel();
						
						// Read byte coming from the client
						final int BUFFER_SIZE = 32;
						ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
						
						try
						{
							client.read(buffer);
						}
						catch (Exception e)
						{
							// client is no longer active
							e.printStackTrace();
							
							continue;
						}
						
						// Show bytes on the console
						buffer.flip();
						
						byte[] arr = buffer.array();
						
						for (int j = 0; j < arr.length; j++)
						{
							System.out.println(arr[j]);
						}
						
						continue;
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
