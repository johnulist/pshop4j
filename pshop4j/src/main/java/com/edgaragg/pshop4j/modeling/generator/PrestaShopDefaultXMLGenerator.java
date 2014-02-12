/**
 * 
 */
package com.edgaragg.pshop4j.modeling.generator;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.edgaragg.pshop4j.modeling.PrestaShopXMLGenerator;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.entities.PrestaShopPojoEntity;

/**
 * @author Edgar Gonzalez
 *
 */
public class PrestaShopDefaultXMLGenerator implements PrestaShopXMLGenerator,
		PrestaShopPojo {

	private static ExecutorService POOL;
	
	static{
		POOL = Executors.newCachedThreadPool();
	}
	
	/**
	 * 
	 */
	public PrestaShopDefaultXMLGenerator() {
	}

	/* (non-Javadoc)
	 * @see com.edgaragg.pshop4j.modeling.PrestaShopXMLGenerator#generate(com.edgaragg.pshop4j.pojos.entities.PrestaShopPojoEntity)
	 */
	@Override
	public InputStream generate(PrestaShopPojoEntity entity) {
		ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);	
		POOL.submit(new InternalPojoReader(entity, buffer));
		return new InternalXMLInputStream(buffer);
	}
	
	private class InternalPojoReader implements Runnable{

		private ByteBuffer internalBuffer;
		
		InternalPojoReader(PrestaShopPojoEntity entity, ByteBuffer buffer){
			this.internalBuffer = buffer;
		}
		
		@Override
		public void run() {
			
		}
		
	}

}
