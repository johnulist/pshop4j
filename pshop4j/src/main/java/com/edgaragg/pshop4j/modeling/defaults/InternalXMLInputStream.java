/**
 * 
 */
package com.edgaragg.pshop4j.modeling.defaults;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Edgar Gonzalez
 *
 */
final class InternalXMLInputStream extends InputStream {

	private ByteArrayInputStream stream;
	
	/**
	 * 
	 */
	public InternalXMLInputStream(byte[] stream) {
		this.stream = new ByteArrayInputStream(stream);
	}

	@Override
	public int read() throws IOException {
        return this.stream.read();
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#read(byte[], int, int)
	 */
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
        return this.stream.read(b, off, len);
	}

	
	/* (non-Javadoc)
	 * @see java.io.InputStream#read(byte[])
	 */
	@Override
	public int read(byte[] b) throws IOException {
        return this.stream.read(b);
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#available()
	 */
	@Override
	public int available() throws IOException {
		return this.stream.available();
	}
	
}
